package sistemaCadastroCompra;

import java.util.Scanner;

public class Loja {
	
	 	static Scanner scan = new Scanner(System.in);
	    static final int MAX_PRODUTOS = 100;

	    static int[] codigos = new int[MAX_PRODUTOS];
	    static String[] descricoes = new String[MAX_PRODUTOS];
	    static double[] precos = new double[MAX_PRODUTOS];
	    static int[] quantidades = new int[MAX_PRODUTOS];
	    static int totalProdutos = 0;

	public static void main(String[] args) {
		
		while(true) {
		
			System.out.println("Bem vindo! Você deseja: \n1 - CASDASTRAR || 2 - COMPRAR ");
			int opcaoMenu = scan.nextInt();
		
			switch(opcaoMenu) {
				case 1:
					cadastrarProduto();
					break;
			
				case 2:
					comprarProduto();
					break;
		
				default:
					System.out.println("Opção inválida.");
			}
		}
	}
	
	public static void cadastrarProduto() {
		
		while (true) {
            if (totalProdutos >= MAX_PRODUTOS) {
                System.out.println("Limite de produtos atingido.");
                return;
            }
            System.out.println("Digite o código do produto:");
            codigos[totalProdutos] = scan.nextInt();       

            System.out.println("Digite a descrição do produto:");
            descricoes[totalProdutos] = scan.next();

            System.out.println("Digite o preço do produto:");
            precos[totalProdutos] = scan.nextDouble();

            System.out.println("Digite a quantidade:");
            quantidades[totalProdutos] = scan.nextInt();

            totalProdutos++;
            System.out.println("Produto cadastrado com sucesso!");
            
            System.out.println("1 - CADASTRAR OUTRO || 2 - VOLTAR AO MENU");
            int opcao = scan.nextInt();
            
            if (opcao != 1) {
            	break;
            }
		}

	}
	
public static void comprarProduto() {
	System.out.println("Digite a descrição do produto que deseja comprar:");
    String descricaoBusca = scan.nextLine().toLowerCase(); 
    
    int indice = -1;
    for (int i = 0; i < totalProdutos; i++) {
        if (descricoes[i].toLowerCase().equals(descricaoBusca)) {
            indice = i;
            break;
        }
    }

    if (indice == -1) {
        System.out.println("Produto não encontrado.");
        return;
    }

    System.out.println("Produto encontrado: " + descricoes[indice]);
    System.out.println("Quantidade disponível: " + quantidades[indice]);
    System.out.println("Digite a quantidade que deseja comprar:");
    int qtdCompra = scan.nextInt();

    if (qtdCompra <= quantidades[indice]) {
        quantidades[indice] -= qtdCompra;
        double total = qtdCompra * precos[indice];
        System.out.println("Compra realizada! Total: R$" + total);
    } else {
        System.out.println("Quantidade insuficiente.");
    }
}
	
}


