package sistemaLocadoraSimples;

public class FilmesVet {
	
	private Filme [] vetor;
	private int quantVetor;


	public FilmesVet (int tamanho) {
		this.vetor = new Filme[tamanho];
		this.quantVetor = 0;
		
	}
		
	public Filme getVetor(int indice) {
		return this.vetor[indice];
	}

	public void setVetor(int indice, Filme novo) {
		this.vetor[indice] = novo;
	}

	public int getQuantVetor() {
		return quantVetor;
	}

	public void setQuantVetor(int novo) {
		this.quantVetor = novo;
	}
	
	public boolean incluirFilme(Filme novo) {
		
		if(this.quantVetor == vetor.length) {
			return false;
		}
		
		else {
			this.vetor[this.quantVetor] = novo;
			this.quantVetor++;
			return true;
		}
	}

	public int pesquisarTotalGenero(char genero){
		
		int contador = 0;
		for(int i=0;i<this.quantVetor;i++){
			if(this.vetor[i].getGenero() == genero) {
				contador++;
			}
		}	
		
		return contador;
	}
   
	public boolean removerFilme(String titulo){
		if(this.quantVetor == 0){
			return false;
		} 
		
		else {
			int i = 0;
			while(i < this.quantVetor && !this.vetor[i].getTitulo().equalsIgnoreCase(titulo)) {
				i++;
			}
			if (i == this.quantVetor) {
				return false;
			} 
		
			else {
				this.vetor[i] = this.vetor[this.quantVetor - 1];
				this.vetor[this.quantVetor - 1] = null;
				this.quantVetor--;
				return true;
			}
		}
	}

}
