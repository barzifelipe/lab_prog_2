package listaExMetodos;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		 
		        Scanner scan = new Scanner(System.in);
		     
		        System.out.print("Digite seu nome completo: ");
		        String nomeCompleto = scan.nextLine();

		        String primeiroNome = obterPrimeiroNome(nomeCompleto);

		        System.out.println("Primeiro nome: " + primeiroNome);

		        scan.close();
		    }

		    public static String obterPrimeiroNome(String nomeCompleto) {
		        String[] partes = nomeCompleto.trim().split(" ");
		        
		        return partes[0];
		    }
		

	}

