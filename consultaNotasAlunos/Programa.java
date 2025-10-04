package consultaNotasAlunos;

import java.util.Scanner;

public class Programa {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;
        AlunosVet alunos = new AlunosVet(500);

        do {
          
            System.out.println("1 - Incluir aluno");
            System.out.println("2 - Consultar alunos com nota 1 e nota 2 abaixo de um valor");
            System.out.println("3 - Mostrar média e nome dos alunos");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    incluirAluno(alunos);
                    break;
                case 2:
                    consultarNotasBaixas(alunos);
                    break;
                case 3:
                    mostrarMedias(alunos);
                    break;
                case 4:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4);
    }

   public static void incluirAluno(AlunosVet alunos) {
        Aluno novo = new Aluno();

        System.out.print("Digite a matrícula: ");
        novo.setMatricula(scan.nextInt());
        scan.nextLine(); 

        System.out.print("Digite o nome do aluno: ");
        novo.setNomeAluno(scan.nextLine());

        System.out.print("Digite a nota 1: ");
        novo.setNota1(scan.nextDouble());

        System.out.print("Digite a nota 2: ");
        novo.setNota2(scan.nextDouble());

        if (alunos.inserirDados(novo)) {
            System.out.println("Aluno cadastrado com sucesso.");
        } else {
            System.out.println("Erro: vetor cheio.");
        }
    }

   public static void consultarNotasBaixas(AlunosVet alunos) {
        System.out.print("Digite o valor de notas máximo: ");
        double limite = scan.nextDouble();

        Aluno[] resultado = alunos.getAlunosNotasBaixas(limite);
        if (resultado.length == 0) {
            System.out.println("Nenhum aluno encontrado com notas abaixo de " + limite);
        } else {
            for (Aluno a : resultado) {
                System.out.println("Aluno: " + a.getNomeAluno());
            }
        }
    }

   public static void mostrarMedias(AlunosVet alunos) {
        double[] medias = alunos.calcularMediaDeTodos();

        for (int i = 0; i < alunos.getQuantVetor(); i++) {
            Aluno a = alunos.getVetor()[i];
            System.out.printf("Aluno: %s | Média: %.2f\n", a.getNomeAluno(), medias[i]);
        }
    }
}
