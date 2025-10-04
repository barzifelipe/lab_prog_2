package listaExMetodos;

import java.util.Scanner;

public class Ex09 {

	  public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);

	        System.out.print("Digite o primeiro número: ");
	        int num1 = scan.nextInt();

	        System.out.print("Digite o segundo número: ");
	        int num2 = scan.nextInt();

	        int mdc = calcularMDC(num1, num2);

	        System.out.println("O Máximo Divisor Comum (MDC) entre " + num1 + " e " + num2 + " é: " + mdc);

	        scan.close();
	    }

	    public static int calcularMDC(int a, int b) {
	        while (b != 0) {
	            int temp = b;
	            b = a % b;
	            a = temp;
	        }
	        return a;
	    }
	}
