package listaExMetodos;

import java.util.Scanner;

public class Ex01 {
	
	
	static void verificaNumero(int numero) {
		if (numero % 2 == 0) {
			System.out.println("Verdadeiro");
		}
		else {
			System.out.println("Falso");
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite um numero:");
		int numero = scan.nextInt();
		verificaNumero(numero);
		
		scan.close();
	}

	

}
