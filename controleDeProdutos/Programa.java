package controleDeProdutos;

import java.util.Scanner;

public class Programa {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        ItensVet estoque = new ItensVet(40);
        int opcao;

        do {
          
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Consultar lucro por código");
            System.out.println("3 - Listar produtos abaixo do estoque mínimo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProduto(estoque);
                    break;
                case 2:
                    consultarLucro(estoque);
                    break;
                case 3:
                    listarEstoqueBaixo(estoque);
                    break;
                case 4:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }

    static void cadastrarProduto(ItensVet estoque) {
        Item novo = new Item();

        System.out.print("Código: ");
        novo.setCodigo(scan.nextInt());
        scan.nextLine();

        System.out.print("Descrição: ");
        novo.setDescricao(scan.nextLine());

        System.out.print("Preço de compra: ");
        novo.setPrecoCompra(scan.nextDouble());

        System.out.print("Preço de venda: ");
        novo.setPrecoVenda(scan.nextDouble());

        System.out.print("Quantidade em estoque: ");
        novo.setQtdEstoque(scan.nextInt());

        System.out.print("Estoque mínimo permitido: ");
        novo.setEstoqueMinimo(scan.nextInt());

        if (estoque.incluirItem(novo)) {
            System.out.println("Produto cadastrado com sucesso.");
        } else {
            System.out.println("Erro: estoque cheio.");
        }
    }

    static void consultarLucro(ItensVet estoque) {
        System.out.print("Digite o código do produto: ");
        int codigo = scan.nextInt();

        double lucro = estoque.calcularLucro(codigo);
        if (lucro == -1) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.printf("Lucro por unidade vendida: R$ %.2f\n", lucro);
        }
    }

    static void listarEstoqueBaixo(ItensVet estoque) {
        Item[] itensCriticos = estoque.listarItensAbaixoMinimo();

        if (itensCriticos.length == 0) {
            System.out.println("Nenhum item abaixo do estoque mínimo.");
        } else {
            System.out.println("Itens com estoque abaixo do mínimo:");
            for (Item i : itensCriticos) {
                System.out.printf("Código: %d | Descrição: %s | Estoque: %d | Mínimo: %d\n",
                        i.getCodigo(), i.getDescricao(), i.getQtdEstoque(), i.getEstoqueMinimo());
            }
        }
    }
}

