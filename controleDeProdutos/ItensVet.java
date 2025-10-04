package controleDeProdutos;

public class ItensVet {

    private Item[] vetor;
    private int quantVetor;

    public ItensVet(int tamanho) {
        this.vetor = new Item[tamanho];
        this.quantVetor = 0;
    }

    public int getQuantVetor() {
        return quantVetor;
    }

    public Item[] getVetor() {
        return vetor;
    }

    public boolean incluirItem(Item novo) {
        if (quantVetor == vetor.length) {
            return false;
        }
        vetor[quantVetor] = novo;
        quantVetor++;
        return true;
    }

    public double calcularLucro(int codigo) {
        for (int i = 0; i < quantVetor; i++) {
            if (vetor[i].getCodigo() == codigo) {
                return vetor[i].getPrecoVenda() - vetor[i].getPrecoCompra();
            }
        }
        return -1; 
    }

    public Item[] listarItensAbaixoMinimo() {
        int count = 0;
        for (int i = 0; i < quantVetor; i++) {
            if (vetor[i].getQtdEstoque() < vetor[i].getEstoqueMinimo()) {
                count++;
            }
        }

        Item[] resultado = new Item[count];
        int index = 0;
        for (int i = 0; i < quantVetor; i++) {
            if (vetor[i].getQtdEstoque() < vetor[i].getEstoqueMinimo()) {
                resultado[index++] = vetor[i];
            }
        }

        return resultado;
    }
}
