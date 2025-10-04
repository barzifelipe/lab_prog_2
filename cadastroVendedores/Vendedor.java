package cadastroVendedores;

public class Vendedor {
	
	private int codigo;
	private String nome;
	private char tipoMercadoria;
	
	public Vendedor(int codigo, String nome, char tipoMercadoria) {
	
		this.codigo = codigo;
		this.nome = nome;
		this.tipoMercadoria = tipoMercadoria;
	}
	
	public Vendedor() {
	
		this.codigo = 0;
		this.nome = "";
		this.tipoMercadoria = ' ';
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getTipoMercadoria() {
		return tipoMercadoria;
	}
	public void setTipoMercadoria(char tipoMercadoria) {
		this.tipoMercadoria = tipoMercadoria;
	}
	
	

}
