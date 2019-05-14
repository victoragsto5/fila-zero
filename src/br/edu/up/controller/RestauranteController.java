package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Pedido;
import br.edu.up.model.Produto;
import br.edu.up.model.Restaurante;
import br.edu.up.swing.Opcoes;

public class RestauranteController {

	private List<Restaurante> restaurantes;

	public RestauranteController() {
		this.restaurantes = new ArrayList<Restaurante>();
		this.abrirRestaurantes();
	}

	public Restaurante receberPedido(Pedido pedido) {
		
		Integer codigoRestaurante = pedido.getRestaurante().getCodigo();
		
		for(Restaurante restaurante: this.restaurantes) {
			if(restaurante.getCodigo().equals(codigoRestaurante)) {
				restaurante.getPedidos().add(pedido);
				this.atualizarPedidos(restaurante);
			}
		}
		
		return null;
	}
	
	public Pedido entregarPedido(Restaurante restaurante, String codigo) {
		
		for(int i = 0; i < restaurante.getPedidos().size(); i++) {
			Pedido pedido = restaurante.getPedidos().get(i);
			if(pedido.getCodigo().toString().equals(codigo)) {
				Pedido pedidoEntregue = restaurante.getPedidos().remove(i);
				restaurante.getPedidosEntregues().add(pedidoEntregue);
				this.atualizarPedidos(restaurante);
				return pedidoEntregue;
			}
		}
		
		return null;
	}
	
	private void atualizarPedidos(Restaurante restaurante) {
		for(int i = 0; i < this.restaurantes.size(); i++) {
			if(this.restaurantes.get(i).getCodigo().equals(restaurante.getCodigo())){
				this.restaurantes.set(i, restaurante);
			}
		}
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
			listaOpcoes.add(Opcoes.SEPARADOR);
		}
		
		String[] arrayOpcoes = listaOpcoes.toArray(new String[0]);
		
		return arrayOpcoes;
	}
	
	public String[] getOpcoesCardapio(Restaurante restaurante) {
		List<String> listaOpcoes = new ArrayList<String>();
		
		listaOpcoes.add(Opcoes.SEPARADOR);
		listaOpcoes.add("CARDÁPIO");		
		listaOpcoes.add(Opcoes.SEPARADOR);
		
		for(Produto produto : restaurante.getCardapio()) {
			String opcao = this.getOpcaoCardapio(produto);
			listaOpcoes.add(opcao); 
		}
		
		listaOpcoes.add(Opcoes.SEPARADOR);
		listaOpcoes.add("0 - Fechar Pedido");
		listaOpcoes.add(Opcoes.SEPARADOR);

		String[] arrayOpcoes =  listaOpcoes.toArray(new String[0]);
		
		return arrayOpcoes;
	}
	
	public String[] getOpcoesPedidos(Restaurante restaurante) {
		List<String> listaOpcoes = new ArrayList<String>();
		
		listaOpcoes.add(Opcoes.SEPARADOR);
		listaOpcoes.add("LISTA PEDIDOS");		
		listaOpcoes.add(Opcoes.SEPARADOR);
		
		for(Pedido pedido : restaurante.getPedidos()) {
			String opcao = this.getOpcaoPedido(pedido);
			listaOpcoes.add(opcao); 
		}
		
		listaOpcoes.add(Opcoes.SEPARADOR);
		listaOpcoes.add("0 - Voltar");
		listaOpcoes.add(Opcoes.SEPARADOR);
		
		String[] arrayOpcoes = listaOpcoes.toArray(new String[0]);
		
		return arrayOpcoes;
	}
	
	public String[] getOpcoesPedidos(List<Pedido> pedidos) {
		List<String> listaOpcoes = new ArrayList<String>();
		
		listaOpcoes.add(Opcoes.SEPARADOR);
		listaOpcoes.add("LISTA PEDIDOS");		
		listaOpcoes.add(Opcoes.SEPARADOR);
		
		for(Pedido pedido : pedidos) {
			String opcao = this.getOpcaoPedido(pedido);
			listaOpcoes.add(opcao); 
		}
		
		listaOpcoes.add(Opcoes.SEPARADOR);
		listaOpcoes.add("0 - Voltar");
		listaOpcoes.add(Opcoes.SEPARADOR);
		
		String[] arrayOpcoes = listaOpcoes.toArray(new String[0]);
		
		return arrayOpcoes;
	}
	
	private String getOpcaoRestaurante(Restaurante restaurante) {
		return restaurante.getCodigo() + " - " + restaurante.getNome();
	}
	
	private String getOpcaoCardapio(Produto produto) {
		return produto.getCodigo() + " - " + produto.getDescricao() + " R$" + produto.getPreco() + "";
	}
	
	private String getOpcaoPedido(Pedido pedido) {
		return pedido.getCodigo() + " - " + pedido.getCliente().getNome() + " - " + pedido.getValorTotal();
	}
	
	private void abrirRestaurantes() {
		this.abrirRestauranteJapones();
		this.abrirPizzaria();
		this.abrirHamburgueria();
	}
	
	private void abrirRestauranteJapones() {
		Restaurante restaurante = new Restaurante();
		List<Produto> cardapio = CardapioController.initializeCardapioJapones();
		
		restaurante.setCodigo(212);
		restaurante.setNome("Restaurante Temaki");
		restaurante.setCardapio(cardapio);
		
		this.restaurantes.add(restaurante);
		
	}
	
	private void abrirPizzaria() {
		Restaurante restaurante = new Restaurante();
		List<Produto> cardapio = CardapioController.initializeCardapioPizzaria();
		
		restaurante.setCodigo(520);
		restaurante.setNome("Pizzaria Giovanella");
		restaurante.setCardapio(cardapio);
		
		this.restaurantes.add(restaurante);
		
	}
	
	private void abrirHamburgueria() {
		Restaurante restaurante = new Restaurante();
		List<Produto> cardapio = CardapioController.initializeCardapioHamburgueria();
		
		restaurante.setCodigo(345);
		restaurante.setNome("Hamburgueria Mac XV");
		restaurante.setCardapio(cardapio);
		
		this.restaurantes.add(restaurante);
		
	}

	public List<Restaurante> getRestaurantes() {
		return this.restaurantes;
	}
	



}
