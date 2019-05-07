package br.edu.up.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {

	private Integer codigo;
	private String nome;
	private List<Produto> cardapio;
	private List<Pedido> pedidos;
	
	public Restaurante() {
		this.pedidos = new ArrayList<Pedido>();
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Produto> getCardapio() {
		return cardapio;
	}

	public void setCardapio(List<Produto> cardapio) {
		this.cardapio = cardapio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
