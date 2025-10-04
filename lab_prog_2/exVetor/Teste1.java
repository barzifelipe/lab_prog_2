package exVetor;

import java.util.Random;

public class Teste1 {

	public static void main(String[] args) {
		
		int[] vetor = new int[4];
		int somaValores = 0;
		//int contador = 0;
		
		for(int i = 0; i <vetor.length;i++) {
			
			vetor[i] = i*2;
			somaValores += vetor[i];
		}
		
		for(int i = 0; i <vetor.length;i++) {
			
			System.out.println("Valor na posição " + i + ": " +vetor[i]);
		}
		
		
		System.out.println("A soma dos valores do vetor é: " + somaValores);
		int media = somaValores/vetor.length;
		System.out.println("A média dos valores do vetor é: " + media);
		
	    vetorAleatorio(vetor);
	   
	}
	

	
	public static void vetorAleatorio(int[] vetor) {
		Random rand = new Random();
		for(int i = 0; i < vetor.length; i++) {
			vetor[i] = rand.nextInt(100);
		}
		for(int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}
		

		
	}

}
