package listaExMetodos;

import java.util.Scanner;

public class Ex06 {

	 public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);

	        int linhas = 3;
	        int colunas = 3;
	        int[][] matriz = new int[linhas][colunas];

	        System.out.println("Digite os valores da matriz " + linhas + "x" + colunas + ":");
	        for (int i = 0; i < linhas; i++) {
	            for (int j = 0; j < colunas; j++) {
	                System.out.print("Valor [" + i + "][" + j + "]: ");
	                matriz[i][j] = scan.nextInt();
	            }
	        }

	        double media = calcularMedia(matriz);

	        System.out.println("A média dos valores da matriz é: " + media);

	        scan.close();
	    }

	    public static double calcularMedia(int[][] matriz) {
	        int soma = 0;
	        int contadorElementos = 0;

	        for (int i = 0; i < matriz.length; i++) {
	            for (int j = 0; j < matriz[i].length; j++) {
	                soma += matriz[i][j];
	               contadorElementos++;
	            }
	        }

	        return (double) soma / contadorElementos;
	    }
	}