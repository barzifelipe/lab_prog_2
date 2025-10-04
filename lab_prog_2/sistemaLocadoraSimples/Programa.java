package sistemaLocadoraSimples;

import java.util.Scanner;

public class Programa {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		char opcao;
		FilmesVet locadora = new FilmesVet(30);
		
		do {
			System.out.println("\n1 - Incluir filme");
			System.out.println("2 - Consultar o total de filmes de um determinado gênero");
			System.out.println("3 - Excluir um filme");
			System.out.println("4 - Listar todos os filmes");
			System.out.println("5 - Sair");
			System.out.print("Escolha uma opção: ");
			
			opcao = scan.next().charAt(0);
			scan.nextLine(); 
			
			switch (opcao) {
				case '1':
					cadastrarFilmes(locadora);
					break;
				case '2':
					buscarGenero(locadora);
					break;
				case '3':
					excluirFilme(locadora);
					break;
				case '4':
					listarFilmes(locadora);
					break;
				case '5':
					System.out.println("Encerrando o programa.");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao != '5');
	}
	
	static void cadastrarFilmes(FilmesVet f) {
		Filme filme = new Filme();
		
		System.out.print("Digite o código do filme: ");
		filme.setCodigo(scan.nextInt());
		scan.nextLine(); 
		
		System.out.print("Digite o título do filme: ");
		filme.setTitulo(scan.nextLine());
		
		System.out.print("Digite o gênero do filme (A - Ação | T - Terror | D - Drama): ");
		filme.setGenero(scan.next().toUpperCase().charAt(0));
		
		if (f.incluirFilme(filme)) {
			System.out.println("Filme cadastrado com sucesso.");
		} else {
			System.out.println("Cadastro não realizado. Arquivo cheio.");
		}
	}
	
	static void buscarGenero(FilmesVet f) {
		System.out.print("Qual o gênero você deseja consultar (A/T/D)? ");
		char genero = scan.next().toUpperCase().charAt(0);
		
		int total = f.pesquisarTotalGenero(genero);
		System.out.println("Total de filmes do gênero '" + genero + "': " + total);
	}
	
	static void excluirFilme(FilmesVet f) {
		System.out.print("Digite o título do filme a ser excluído: ");
		String titulo = scan.nextLine();
		
		if (f.removerFilme(titulo)) {
			System.out.println("Filme removido com sucesso.");
		} else {
			System.out.println("Filme não encontrado.");
		}
	}
	
	static void listarFilmes(FilmesVet f) {
		if (f.getQuantVetor() == 0) {
			System.out.println("Nenhum filme cadastrado.");
		} else {
			for (int i = 0; i < f.getQuantVetor(); i++) {
				Filme filme = f.getVetor(i);
				System.out.println("Código: " + filme.getCodigo() +
						" | Título: " + filme.getTitulo() +
						" | Gênero: " + filme.getGenero());
			}
		}
	}
}
