package br.edu.up.model;

public class Produto {

	private Integer codigo;
	private String descricao;
	private Double preco;

	public Produto(Integer codigo, String descricao, Double preco) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
