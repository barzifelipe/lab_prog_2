package exTryCatch;

import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		 Random rand = new Random();
		 
	
		try 
		    (
				Scanner primeiroScanner = new Scanner (new FileReader("primeiroNome.txt"));
				Scanner ultimoScanner = new Scanner (new FileReader("ultimoNome.txt"));
				
		    ) {
			
			while (primeiroScanner.hasNext() && ultimoScanner.hasNext()) {
				
				String primeiroNome = primeiroScanner.next();
				String ultimoNome = ultimoScanner.next();
				int idade = rand.nextInt(100);
				
				int qtdLetras = rand.nextInt(3);
				StringBuilder iniciais = new StringBuilder();
				
				 for (int i = 0; i < qtdLetras; i++) {
	                    char letra = (char) ('A' + rand.nextInt(26)); 
	                    iniciais.append(" ").append(letra).append(".");
	            }
				 
				 System.out.println(primeiroNome + iniciais + " " + ultimoNome + " tem " +
	                        idade + " anos de idade.");
		}
	} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
