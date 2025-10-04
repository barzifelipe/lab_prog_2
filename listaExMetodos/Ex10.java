package listaExMetodos;

import java.util.Scanner;

public class Ex10 {

	 public static void main(String[] args) {
		 
	        Scanner scan = new Scanner(System.in);

	        System.out.print("Digite um número: ");
	        int numero = scan.nextInt();

	        if (verificarPrimo(numero)) {
	            System.out.println(numero + " é um número primo.");
	        } else {
	            System.out.println(numero + " não é um número primo.");
	        }

	        scan.close();
	    }

	    public static boolean verificarPrimo(int numero) {
	        if (numero <= 1) {
	            return false;
	        }

	        for (int i = 2; i <= numero / 2; i++) {
	            if (numero % i == 0) {
	                return false;
	            }
	        }
	        
	        return true;
	    }
	}
