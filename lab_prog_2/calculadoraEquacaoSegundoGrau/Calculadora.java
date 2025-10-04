package calculadoraEquacaoSegundoGrau;

import java.util.Scanner;

/*  
 * * 1 - perguntar os numeros
 *  * 2 - ler os numeros 
 *  * 3 - validar os numeros 
 *  * 4 - fazer delta 
 *  * 5 - calcular as raizes
 *   */

public class Calculadora {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double numA;

        do {
            System.out.println("Digite o valor de a: ");
            numA = scan.nextDouble();

            if (numA == 0) {
                System.out.println("O valor de a deve ser diferente de 0");
            }

        } while (numA == 0);

        System.out.println("Digite o valor de b: ");
        double numB = scan.nextDouble();

        System.out.println("Digite o valor de c: ");
        double numC = scan.nextDouble();

        double delta = calcularDelta(numA, numB, numC);
        calcularRaizes(numA, numB, numC, delta);

        scan.close();
    }

    public static double calcularDelta(double numA, double numB, double numC) {
        return numB * numB - 4 * numA * numC;
    }

    public static void calcularRaizes(double numA, double numB, double numC, double delta) {
        if (delta > 0) {
            double raiz = Math.sqrt(delta);
            double x1 = (-numB + raiz) / (2 * numA);
            double x2 = (-numB - raiz) / (2 * numA);
            System.out.println("As raízes da equação são: " + x1 + " e " + x2);
        } 
        
        else if (delta == 0) {
            double x = (-numB) / (2 * numA);
            System.out.println("O delta é igual a 0. Então a equação tem uma raiz real dupla: " + x);
        } 
        
        else {
            System.out.println("Não foi possível calcular as raízes reais porque o delta é negativo.");
        }
    }
}
	


