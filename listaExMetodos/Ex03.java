package listaExMetodos;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int vetor[] = new int [3];
		
		for(int i = 0; i < vetor.length; i++) {
			System.out.println("Digite os valor " + i + " do vetor");
			vetor[i] = scan.nextInt();		
		}
		verificarMaior(vetor);
		
		scan.close();
	}
	
	public static int verificarMaior(int[] vetor) {
		int maior = vetor[0];
		
		for(int i = 0; i < vetor.length; i++) {
			if(vetor[i] > maior) {
				maior = vetor[i];
			}
		}
		System.out.println("O maior valor contido no vetor é: " + maior);
		return maior;
	}

}
