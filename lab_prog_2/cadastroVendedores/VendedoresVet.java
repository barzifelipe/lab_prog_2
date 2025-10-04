package cadastroVendedores;

public class VendedoresVet {
	
	private Vendedor [] vetor;
	private int quantVetor;


	public VendedoresVet (int tamanho) {
		this.vetor = new Vendedor[tamanho];
		this.quantVetor = 0;
		
	}

	public Vendedor[] getVetor() {
		return vetor;
	}


	public void setVetor(Vendedor[] vetor) {
		this.vetor = vetor;
	}


	public int getQuantVetor() {
		return quantVetor;
	}


	public void setQuantVetor(int quantVetor) {
		this.quantVetor = quantVetor;
	}
	
	public boolean incluirVendedor(Vendedor novo) {
		
		if(this.quantVetor == vetor.length) {
			return false;
		}
		
		else {
			this.vetor[this.quantVetor] = novo;
			this.quantVetor++;
			return true;
		}
	}

	public int pesquisarTotalTVendedor(char tipoMercadoria){
	
		int contador = 0;
		for(int i=0;i<this.quantVetor;i++){
			if(this.vetor[i].getTipoMercadoria() == tipoMercadoria) {
				contador++;
			}
		}	
	
		return contador;
	}
	
	public boolean removerVendedor(String nome){
		
		if(this.quantVetor==0){
			return false;
		}
		
		else {
			int i = 0;
			while(i < this.quantVetor && !this.vetor[i].getNome().equals(nome)) {
				i++;
			}
			
			if (i == this.quantVetor) {
				return false;
			}
			
			else {
				this.vetor[i] = this.vetor[this.quantVetor-1];
				this.quantVetor--;
				return true;
			}
			
		
		}
		
	}


}
