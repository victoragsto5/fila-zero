package br.edu.up.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.up.model.Pedido;
import br.edu.up.model.Produto;
import br.edu.up.model.Restaurante;

public class RestauranteController {

	private List<Restaurante> restaurantes;

	public RestauranteController() {
		this.restaurantes = new ArrayList<Restaurante>();
		this.abrirRestaurantes();
	}

	public Restaurante receberPedido(Pedido pedido) {
		
		Integer codigoRestaurante = pedido.getRestaurante().getCodigo();
		pedido.setDataPedido(new Date());
		
		int i = 0;
		
		for(Restaurante restaurante: this.restaurantes) {
			if(restaurante.getCodigo().toString().equals(codigoRestaurante)) {
				this.restaurantes.get(i).getPedidos().add(pedido);
			}
			i++;
		}
		
		return null;
	}
	
	public Pedido entregarPedido(String codigoPedido) {
		for(int i = 0; i < this.restaurantes.size(); i++) {
			for(int x = 0; x < this.restaurantes.get(i).getPedidos().size(); x++) {
				this.restaurantes.get(i).getPedidos().remove(x);
			}
		}
		
		return null;
	}
	
	public Restaurante buscaRestaurantePorCodigo(String codigo) {
		
		for(Restaurante restaurante: this.restaurantes) {
			if(restaurante.getCodigo().toString().equals(codigo)) {
				return restaurante;
			}
		}
		
		return null;
	}
	
	public Produto buscaNoCardapio(Restaurante restaurante, String codigo) {
		
		List<Produto> cardapio = restaurante.getCardapio();
		
		for(Produto produto: cardapio) {
			if(produto.getCodigo().toString().equals(codigo)) {
				return produto;
			}
		}
		
		return null;
	}
	
	public String[] getOpcoesRestaurante() {
		List<String> listaOpcoes = new ArrayList<String>();
		
		for(Restaurante restaurante : this.restaurantes) {
			String opcao = this.getOpcaoRestaurante(restaurante);
			listaOpcoes.add(opcao); 
		}
		
		String[] arrayOpcoes = listaOpcoes.toArray(new String[0]);
		
		return arrayOpcoes;
	}
	
	public String[] getOpcoesCardapio(Restaurante restaurante) {
		List<String> listaOpcoes = new ArrayList<String>();
		
		for(Produto produto : restaurante.getCardapio()) {
			String opcao = this.getOpcaoCardapio(produto);
			listaOpcoes.add(opcao); 
		}
		
		listaOpcoes.add("[0] - [Fechar Pedido]");
		String[] arrayOpcoes =  listaOpcoes.toArray(new String[0]);
		
		return arrayOpcoes;
	}
	
	private String getOpcaoRestaurante(Restaurante restaurante) {
		return restaurante.getCodigo() + " - " + restaurante.getNome();
	}
	
	private String getOpcaoCardapio(Produto produto) {
		return produto.getCodigo() + " - " + produto.getDescricao() + " R$" + produto.getPreco() + "";
	}
	
	private void abrirRestaurantes() {
		this.abrirRestauranteJapones();
		this.abrirPizzaria();
		this.abrirHamburgueria();
	}
	
	private void abrirRestauranteJapones() {
		Restaurante restaurante = new Restaurante();
		List<Produto> cardapio = CardapioController.initializeCardapioJapones();
		
		restaurante.setCodigo(1);
		restaurante.setNome("Restaurante Temaki");
		restaurante.setCardapio(cardapio);
		
		this.restaurantes.add(restaurante);
		
	}
	
	private void abrirHamburgueria() {
		Restaurante restaurante = new Restaurante();
		List<Produto> cardapio = CardapioController.initializeCardapioHamburgueria();
		
		restaurante.setCodigo(2);
		restaurante.setNome("Hamburgueria Mac XV");
		restaurante.setCardapio(cardapio);
		
		this.restaurantes.add(restaurante);
		
	}
	
	private void abrirPizzaria() {
		Restaurante restaurante = new Restaurante();
		List<Produto> cardapio = CardapioController.initializeCardapioPizzaria();
		
		restaurante.setCodigo(3);
		restaurante.setNome("Pizzaria Giovanella");
		restaurante.setCardapio(cardapio);
		
		this.restaurantes.add(restaurante);
		
	}
	



}
