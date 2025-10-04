package consultaNotasAlunos;

public class AlunosVet {

    private Aluno[] vetor;
    private int quantVetor;

    public AlunosVet(int tamanho) {
        this.vetor = new Aluno[tamanho];
        this.quantVetor = 0;
    }

    public Aluno[] getVetor() {
        return vetor;
    }

    public void setVetor(Aluno[] vetor) {
        this.vetor = vetor;
    }

    public int getQuantVetor() {
        return quantVetor;
    }

    public void setQuantVetor(int quantVetor) {
        this.quantVetor = quantVetor;
    }

    public boolean inserirDados(Aluno novo) {
        if (this.quantVetor == this.vetor.length) {
            return false;
        } else {
            this.vetor[this.quantVetor] = novo;
            this.quantVetor++;
            return true;
        }
    }

    public int contarNotasBaixas(double limite) {
        int contador = 0;
        for (int i = 0; i < this.quantVetor; i++) {
            if (vetor[i].getNota1() < limite && vetor[i].getNota2() < limite) {
                contador++;
            }
        }
        return contador;
    }

    public Aluno[] getAlunosNotasBaixas(double limite) {
        int total = contarNotasBaixas(limite);
        Aluno[] resultado = new Aluno[total];
        int idx = 0;

        for (int i = 0; i < this.quantVetor; i++) {
            if (vetor[i].getNota1() < limite && vetor[i].getNota2() < limite) {
                resultado[idx++] = vetor[i];
            }
        }

        return resultado;
    }

    public double[] calcularMediaDeTodos() {
        double[] medias = new double[this.quantVetor];
        for (int i = 0; i < this.quantVetor; i++) {
            Aluno a = vetor[i];
            medias[i] = (a.getNota1() + a.getNota2()) / 2.0;
        }
        return medias;
    }
}