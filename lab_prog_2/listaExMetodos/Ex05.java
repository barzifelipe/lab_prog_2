package listaExMetodos;

import java.util.Scanner;

public class Ex05 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int vetor[] = new int[3]; 

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite o valor " + i + " do vetor:");
            vetor[i] = scan.nextInt();
        }

        int[] pares = filtrarPares(vetor);

        System.out.println("Valores pares do vetor:");
        for (int i = 0; i < pares.length; i++) {
            System.out.println(pares[i]);
        }

        scan.close();
    }

    public static int[] filtrarPares(int[] vetor) {
        
        int quantidadePares = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                quantidadePares++;
            }
        }
  
        int[] pares = new int[quantidadePares];
        int index = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                pares[index] = vetor[i];
                index++;
            }
        }

        return pares;
    }
}


