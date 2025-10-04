package listaExMetodos;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite um numero: ");
		int numero = scan.nextInt();
		
		calcularFatorial(numero);
		
		scan.close();
	}
	
	public static int calcularFatorial(int numero) {
		int resultado =1;
		
		for (int i = 1; i <= numero; i++) {
			resultado *= i;
		}
		
		System.out.println("Fatorial de " + numero + " é " + resultado);
		return resultado;
		
	}

}
