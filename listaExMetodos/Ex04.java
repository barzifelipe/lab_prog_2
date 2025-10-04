package listaExMetodos;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite uma palavra: ");
		String palavra = scan.next();
		
		contadorVogais(palavra);
		
		scan.close();
	}
	
	public static int contadorVogais(String palavra){
		int numeroVogais = 0;
		
		for(int i = 0; i < palavra.length(); i++) {
			char letra = palavra.charAt(i);
			
			if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
				numeroVogais++;
			}
		}
		
		System.out.println("Número de vogais: " + numeroVogais);
		return numeroVogais;
	}

}
