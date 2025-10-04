package controleDeProdutos;

public class Item {
	
	private int codigo;
	private String descricao;
	private double precoCompra;
	private double precoVenda;
	private int qtdEstoque;
	private int estoqueMinimo;



	public Item(int codigo, String descricao, double precoCompra, double precoVenda, int qtdEstoque, int estoqueMinimo) {
		
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.qtdEstoque = qtdEstoque;
		this.estoqueMinimo = estoqueMinimo;
	}
	
	public Item() {
		
		this.codigo = 0;
		this.descricao = "";
		this.precoCompra = 0;
		this.precoVenda = 0;
		this.qtdEstoque = 0;
		this.estoqueMinimo = 0;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}
	
	
}

