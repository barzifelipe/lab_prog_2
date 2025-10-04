package listaExMetodos;

import java.util.Scanner;

public class Ex08 {

    public static void main(String[] args) {
    	
        Scanner scan = new Scanner(System.in);

        int[] vetor = new int[3];

        System.out.println("Digite 3 números:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            vetor[i] = scan.nextInt();
        }

        System.out.print("Digite um valor N: ");
        int N = scan.nextInt();

        int[] maiores = verificarMaior(vetor, N);

        System.out.println("Valores maiores que " + N + ":");
        for (int valor : maiores) {
            System.out.println(valor);
        }

        scan.close();
    }

    public static int[] verificarMaior(int[] vetor, int N) {
        int contador = 0;
        for (int valor : vetor) {
            if (valor > N) {
                contador++;
            }
        }

        int[] resultado = new int[contador];
        int index = 0;

        for (int valor : vetor) {
            if (valor > N) {
                resultado[index] = valor;
                index++;
            }
        }

        return resultado;
    }
}