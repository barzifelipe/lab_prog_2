package trabalhoFinalLocadora;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FilmeMain {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        VetorFilme locadora = new VetorFilme(50);
        VetorUsuario usuario = new VetorUsuario(50);

        carregarFilmesDoArquivo(locadora);
        carregarUsuariosDoArquivo(usuario);

        char opcao;

        do {
            System.out.println("--- Menu Geral ---");
            System.out.println("1. Filmes");
            System.out.println("2. Usuários");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scan.next().charAt(0);
            scan.nextLine();

            switch (opcao) {
                case '1':
                    menuFilme(locadora, usuario);
                    break;
                case '2':
                    menuUsuario(usuario);
                    break;
                case '3':
                    System.out.println("\n===== VOLTE SEMPRE :) =====");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != '3');
    }

    static void menuFilme(VetorFilme vetFilm, VetorUsuario vetUsuario) {
        System.out.println("\n--- Menu Filmes ---");
        System.out.println("1. Alugar Filme");
        System.out.println("2. Cadastrar Filme");
        System.out.println("3. Pesquisar Filme");
        System.out.println("4. Excluir Filme");
        System.out.println("5. Mostrar Filmes");
        System.out.println("6. Voltar");
        System.out.print("Escolha uma opção: ");
        char opcao = scan.next().charAt(0);
        scan.nextLine();

        switch (opcao) {
            case '1':
                alugarFilme(vetFilm, vetUsuario);
                salvarFilmesEmArquivo(vetFilm);
                break;
            case '2':
                cadastrarFilme(vetFilm);
                salvarFilmesEmArquivo(vetFilm);
                break;
            case '3':
                pesquisarFilme(vetFilm);
                break;
            case '4':
                excluirFilme(vetFilm);
                salvarFilmesEmArquivo(vetFilm);
                break;
            case '5':
                mostrarFilmes(vetFilm);
                break;
            case '6':
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    static void alugarFilme(VetorFilme vetFilm, VetorUsuario vetUsuario) {
        System.out.println("\n--- Filmes Disponíveis ---");
        boolean temDisponivel = false;
        for (int i = 0; i < vetFilm.getQtdFilme(); i++) {
            Filme f = vetFilm.getVetFilme(i);
            if (f.getSituacao().equalsIgnoreCase("disponível")) {
                System.out.println(f.toString());
                System.out.println("--------------------------");
                temDisponivel = true;
            }
        }
        if (!temDisponivel) {
            System.out.println("Nenhum filme disponível para aluguel no momento.");
            return;
        }

        System.out.print("Digite o código do filme que deseja alugar: ");
        int cod = scan.nextInt();
        scan.nextLine();

        Filme filme = vetFilm.buscarPorCodigo(cod);
        if (filme != null) {
            if (filme.getSituacao().equalsIgnoreCase("disponível")) {
                // Pedir dados do cliente
                System.out.print("Digite o CPF do cliente que está alugando: ");
                String cpf = scan.nextLine();

                Usuario cliente = null;
                for (int i = 0; i < vetUsuario.getqtdUsuario(); i++) {
                    Usuario u = vetUsuario.getvetUsuario(i);
                    if (u.getCpf().equalsIgnoreCase(cpf)) {
                        cliente = u;
                        break;
                    }
                }

                if (cliente == null) {
                    System.out.println("Cliente não encontrado. Por favor, cadastre o cliente antes de alugar.");
                    return;
                }

                filme.setSituacao("indisponível");

                System.out.println("\n=== Confirmação do Aluguel ===");
                System.out.println("Cliente:");
                System.out.println(cliente.toString());
                System.out.println("Filme:");
                System.out.println(filme.toString());
                System.out.println("Aluguel efetuado com sucesso!");

                
                salvarAluguelEmArquivo(cliente.getCpf(), cliente.getNome(), filme);

            } 
           
            else {
                System.out.println("Filme já está alugado.");
            }
        } 
        
        else {
            System.out.println("Filme não encontrado.");
        }
    }

    static void salvarAluguelEmArquivo(String cpfCliente, String nomeCliente, Filme filme) {
        try (FileWriter fw = new FileWriter("alugueis.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {

            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataHora = agora.format(formatter);

            pw.println(cpfCliente + ";" + nomeCliente + ";" + filme.getCodFilme() + ";" + filme.getTitulo() + ";" + dataHora);

        } catch (Exception e) {
            System.out.println("Erro ao salvar aluguel no arquivo: " + e.getMessage());
        }
    }

    static void cadastrarFilme(VetorFilme vetFilm) {
        System.out.print("Digite o código do filme: ");
        int cod = scan.nextInt();
        scan.nextLine();

        System.out.print("Digite o título do filme: ");
        String titulo = scan.nextLine();

        System.out.print("Digite o gênero (A – Ação, T – Terror, D – Drama): ");
        char genero = scan.next().toUpperCase().charAt(0);
        scan.nextLine();

        System.out.print("Digite a classificação: ");
        int classificacao = scan.nextInt();
        scan.nextLine();

        System.out.print("Digite a situação (disponível/indisponível): ");
        String situacao = scan.nextLine();

        Filme filme = new Filme(cod, titulo, genero, classificacao, situacao);
        if (vetFilm.insereFilme(filme)) {
            System.out.println("Filme cadastrado com sucesso :)");
        } 
        
        else {
            System.out.println("Arquivo de filmes cheio :(");
        }
    }

    static void pesquisarFilme(VetorFilme vetFilm) {
        System.out.print("Digite o título do filme para pesquisa: ");
        String titulo = scan.nextLine();

        Filme filme = vetFilm.buscarPorTitulo(titulo);
        if (filme != null) {
            System.out.println("\nFilme encontrado:");
            System.out.println(filme.toString());
        } 
        
        else {
            System.out.println("Filme não encontrado.");
        }
    }

    static void excluirFilme(VetorFilme vetFilm) {
        System.out.println("Deseja excluir pelo código (C) ou pelo título (T)?");
        char escolha = scan.next().toUpperCase().charAt(0);
        scan.nextLine();

        boolean sucesso = false;
        if (escolha == 'C') {
            System.out.print("Digite o código do filme a excluir: ");
            int cod = scan.nextInt();
            scan.nextLine();
            sucesso = vetFilm.excluirFilmePorCodigo(cod);
        } 
        
        else if (escolha == 'T') {
            System.out.print("Digite o título do filme a excluir: ");
            String titulo = scan.nextLine();
            sucesso = vetFilm.excluirFilmePorTitulo(titulo);
        }

        if (sucesso) {
            System.out.println("Filme removido com sucesso.");
        } 
        
        else {
            System.out.println("Filme não encontrado.");
        }
    }

    static void mostrarFilmes(VetorFilme vetFilm) {
        System.out.println("\n--- Lista de Filmes ---");
        for (int i = 0; i < vetFilm.getQtdFilme(); i++) {
            Filme f = vetFilm.getVetFilme(i);
            System.out.println(f.toString());
            System.out.println("------------------------");
        }
    }

    static void menuUsuario(VetorUsuario usuario) {
        char opcao;

        do {
            System.out.println("\n--- Menu Usuários ---");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Pesquisar Usuário");
            System.out.println("3. Excluir Usuário");
            System.out.println("4. Mostrar Usuários");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scan.next().charAt(0);
            scan.nextLine();

            switch (opcao) {
                case '1':
                    cadastrarUsuario(usuario);
                    salvarUsuariosEmArquivo(usuario);
                    break;
                case '2':
                    pesquisarUsuario(usuario);
                    break;
                case '3':
                    excluirUsuario(usuario);
                    salvarUsuariosEmArquivo(usuario);
                    break;
                case '4':
                    mostrarClientes(usuario);
                    break;
                case '5':
             
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != '5');
    }

    static void cadastrarUsuario(VetorUsuario vetusuario) {
        System.out.print("Digite o CPF: ");
        String cpf = scan.nextLine();

        System.out.print("Digite o nome: ");
        String nome = scan.nextLine();

        System.out.print("Digite o telefone: ");
        String telefone = scan.nextLine();

        System.out.print("Digite o endereço: ");
        String endereco = scan.nextLine();

        System.out.print("Digite o tipo de usuário (C para cliente e F para Funcionario): ");
        char tipoUsuario = scan.nextLine().charAt(0);

        Cliente cliente = new Cliente(cpf, telefone, endereco, tipoUsuario, nome);

        if (vetusuario.insereUsuario(cliente)) {
            System.out.println("Usuário cadastrado com sucesso :)");
        } else {
            System.out.println("Arquivo de usuários cheio :(");
        }
    }

    static void pesquisarUsuario(VetorUsuario vetUsuario) {
        System.out.print("Digite o CPF do usuário para pesquisa: ");
        String cpf = scan.nextLine();

        Usuario usuario = null;
        for (int i = 0; i < vetUsuario.getqtdUsuario(); i++) {
            Usuario u = vetUsuario.getvetUsuario(i);
            if (u.getCpf().equalsIgnoreCase(cpf)) {
                usuario = u;
                break;
            }
        }

        if (usuario != null) {
            System.out.println("Usuário encontrado:");
            System.out.println(usuario.toString());
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    static void excluirUsuario(VetorUsuario vetUsuario) {
        System.out.print("Digite o CPF do usuário a excluir: ");
        String cpf = scan.nextLine();

        boolean removido = false;
        for (int i = 0; i < vetUsuario.getqtdUsuario(); i++) {
            Usuario u = vetUsuario.getvetUsuario(i);
            if (u.getCpf().equalsIgnoreCase(cpf)) {
                

                for (int j = i; j < vetUsuario.getqtdUsuario() - 1; j++) {
                    vetUsuario.vetUsuario[j] = vetUsuario.vetUsuario[j + 1];
                }
                try {
                    java.lang.reflect.Field field = VetorUsuario.class.getDeclaredField("qtdUsuario");
                    field.setAccessible(true);
                    field.setInt(vetUsuario, vetUsuario.getqtdUsuario() - 1);
                } catch (Exception e) {
                    System.out.println("Erro ao atualizar quantidade de usuários.");
                }

                removido = true;
                break;
            }
        }

        if (removido) {
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    static void mostrarClientes(VetorUsuario vetUsuario) {
        System.out.println("\n--- Lista de Usuários  ---");
        for (int i = 0; i < vetUsuario.getqtdUsuario(); i++) {
            Usuario u = vetUsuario.getvetUsuario(i);
            System.out.println(u.toString());
            System.out.println("------------------------");
        }
    }

    static void salvarFilmesEmArquivo(VetorFilme vetFilm) {
        try {
            FileWriter out = new FileWriter("filmes.txt");
            PrintWriter arquivo = new PrintWriter(out);

            for (int i = 0; i < vetFilm.getQtdFilme(); i++) {
                Filme f = vetFilm.getVetFilme(i);
                arquivo.println(f.getCodFilme() + ";" + f.getTitulo() + ";" +
                        f.getGenero() + ";" + f.getClassificacao() + ";" +
                        f.getSituacao());
            }

            arquivo.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar filmes no arquivo: " + e.getMessage());
        }
    }

    static void carregarFilmesDoArquivo(VetorFilme vetFilm) {
        try {
            File arquivo = new File("filmes.txt");
            if (!arquivo.exists()) return;

            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] partes = linha.split(";");
                if (partes.length == 5) {
                    int cod = Integer.parseInt(partes[0]);
                    String titulo = partes[1];
                    char genero = partes[2].charAt(0);
                    int classificacao = Integer.parseInt(partes[3]);
                    String situacao = partes[4];

                    Filme f = new Filme(cod, titulo, genero, classificacao, situacao);
                    vetFilm.insereFilme(f);
                }
            }

            leitor.close();
        } catch (Exception e) {
            System.out.println("Erro ao carregar filmes do arquivo: " + e.getMessage());
        }
    }

    static void salvarUsuariosEmArquivo(VetorUsuario vetUsuario) {
        try {
            FileWriter out = new FileWriter("usuarios.txt");
            PrintWriter arquivo = new PrintWriter(out);

            for (int i = 0; i < vetUsuario.getqtdUsuario(); i++) {
                Usuario u = vetUsuario.getvetUsuario(i);
                arquivo.println(u.getCpf() + ";" + u.getNome() + ";" + u.getTelefone() + ";" +
                        u.getEndereco() + ";" + u.getTipoUsuario());
            }

            arquivo.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar usuários no arquivo: " + e.getMessage());
        }
    }

    static void carregarUsuariosDoArquivo(VetorUsuario vetUsuario) {
        try {
            File arquivo = new File("usuarios.txt");
            if (!arquivo.exists()) return;

            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] partes = linha.split(";");
                if (partes.length == 5) {
                    String cpf = partes[0];
                    String nome = partes[1];
                    String telefone = partes[2];
                    String endereco = partes[3];
                    char tipoUsuario = partes[4].charAt(0);

                    Cliente c = new Cliente(cpf, telefone, endereco, tipoUsuario, nome);
                    vetUsuario.insereUsuario(c);
                }
            }

            leitor.close();
        } catch (Exception e) {
            System.out.println("Erro ao carregar usuários do arquivo: " + e.getMessage());
        }
    }
}
