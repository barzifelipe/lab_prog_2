package sistemaMediaIdade;

import java.util.Scanner;

public class Programa {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Qual será a quantidade de funcionários a ser cadastrados? ");
		int quant = scan.nextInt();
		
		Funcionario[] medFunc = new Funcionario[quant];	
		
		lerIdades(medFunc);
		mostrarIdades(medFunc);
		int maior = mostrarMaior(medFunc);
		System.out.println("A maior das idades é: " + maior);
		double media = calcularMedia(medFunc);
		System.out.println("Média das idades: " + media);
		
		}
	
	public static void lerIdades(Funcionario[] medFunc) {
		
		for (int i = 0; i < medFunc.length; i++) {
			
			medFunc[i] = new Funcionario();
			
			System.out.println("Dgite a idade do fucionario " + (i + 1) + ":");
			int idade = scan.nextInt();
			medFunc[i].setIdade(idade);
		}		
	}
	
	public static void mostrarIdades(Funcionario[] medFunc) {
		
		for (int i = 0; i < medFunc.length; i++) {
			System.out.println(medFunc[i].getIdade());
		}
	}
	
	public static int mostrarMaior(Funcionario[] medFunc) {
		int maior = 0;
		for (int i = 0; i < medFunc.length; i++) {
			if (medFunc[i].getIdade() > maior) {
				maior = medFunc[i].getIdade();
			}
		}
		return maior;
	}
	
	public static double calcularMedia(Funcionario[] medFunc) {
		 int soma = 0;
		 for (int i = 0; i < medFunc.length; i++) {
			 soma += medFunc[i].getIdade();
		 }
		
		return  soma/medFunc.length;
	}
	
	

}
