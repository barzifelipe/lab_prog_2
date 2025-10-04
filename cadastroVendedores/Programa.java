package cadastroVendedores;

import java.util.Scanner;

public class Programa {
	
	static Scanner scan = new Scanner (System.in);

	public static void main(String[] args) {
		
		int opcao;
		VendedoresVet vendedores = new VendedoresVet(30);
		
		do {
			
			System.out.println("Escolha uma opção: ");
			System.out.println("1 - Incluir vendedor");
			System.out.println("2 - Consultar o total de vendedores de um determinado tipo mercadoria");
			System.out.println("3 - Excluir um vendedor");
			System.out.println("4 - Listar todos os vendedores");
			System.out.println("5 - Sair");
			
			opcao = scan.nextInt();
			
			switch(opcao) {
		    case 1:
		        incluirVendedor(vendedores);
		        break;
		    case 2:
		        buscarTipo(vendedores);
		        break;
		    case 3:
		        excluirVendedor(vendedores);
		        break;
		    case 4:
		        listarVendedores(vendedores);
		        break;
		    case 5:
		        System.out.println("Programa encerrado");
		        break;
		    default: 
		        System.out.println("Opção inválida. Tente novamente");
			}
		
		}while (opcao != 5);
	}
	
	public static void incluirVendedor(VendedoresVet v) {
	    Vendedor vendedor = new Vendedor();

	    System.out.println("Digite o código do vendedor: ");
	    vendedor.setCodigo(scan.nextInt());
	    scan.nextLine(); 

	    System.out.println("Digite o nome do vendedor: ");
	    vendedor.setNome(scan.nextLine());

	    System.out.println("Digite o tipo de mercadoria vendida por ele (P – perecível | N – não perecível): ");
	    vendedor.setTipoMercadoria(scan.next().toUpperCase().charAt(0));

	    if (v.incluirVendedor(vendedor)) {
	        System.out.println("Vendedor cadastrado com sucesso.");
	    } else {
	        System.out.println("Cadastro não realizado. Arquivo cheio.");
	    }
	}
	
	public static void buscarTipo(VendedoresVet v) {
	    System.out.println("Digite o tipo de mercadoria (P/N): ");
	    char tipo = scan.next().toUpperCase().charAt(0);
	    int total = v.pesquisarTotalTVendedor(tipo);
	    System.out.println("Total de vendedores do tipo '" + tipo + "': " + total);
	}
	
	public static void excluirVendedor(VendedoresVet v) {
	    scan.nextLine(); 
	    System.out.println("Digite o nome do vendedor a ser removido: ");
	    String nome = scan.nextLine();

	    if (v.removerVendedor(nome)) {
	        System.out.println("Vendedor removido com sucesso.");
	    } else {
	        System.out.println("Vendedor não encontrado.");
	    }
	}
	
	public static void listarVendedores(VendedoresVet v) {
	    System.out.println("Lista de Vendedores:");
	    for (int i = 0; i < v.getQuantVetor(); i++) {
	        Vendedor vend = v.getVetor()[i];
	        System.out.println("Código: " + vend.getCodigo() +
	                           ", Nome: " + vend.getNome() +
	                           ", Tipo Mercadoria: " + vend.getTipoMercadoria());
	    }
	}
}
