package sistemaLocadoraSimples;

public class Filme {
	
	
	private int codigo;
	private String titulo;
	private char genero;
	
	public Filme() {
		this.codigo = 0;
		this.titulo = "";
		this.genero = ' ';
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	

}
