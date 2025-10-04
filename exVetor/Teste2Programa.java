package exVetor;

import java.util.Scanner;

public class Teste2Programa {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		
		Teste2Aluno[] aluno = new Teste2Aluno[3];
		double somaNotas[] = new double[3];
		double mediaNotas[] = new double[3];
 		
		
		for(int i = 0; i < aluno.length;i++) {
			
			aluno[i] = new Teste2Aluno();
			
			System.out.println("Digite o nome do aluno " + (i+1) + ": ");
			aluno[i].setNome(scan.next());
			
			
			double[] notas = new double[3];
			somaNotas[i] = 0; 
			mediaNotas[i] = 0;
			
			for(int j = 0; j < notas.length; j++) {
				
			    System.out.println("Digite a nota " + (j+1) + " do aluno: ");
				notas[j] = scan.nextDouble();
				somaNotas[i] += notas[j];
			}		
			aluno[i].setNotas(notas);
			mediaNotas[i] = somaNotas[i]/notas.length;
		}
		
		for(int i = 0; i < aluno.length;i++) {
			System.out.println(aluno[i].getNome());
			System.out.println(mediaNotas[i]);
		}
				
		scan.close();
	}
}
