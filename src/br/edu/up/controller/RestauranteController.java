package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Pedido;

public class RestauranteController {

	private List<Pedido> pedidos;

	public RestauranteController() {
		this.pedidos = new ArrayList<Pedido>();
	}

	public void cadastrarPedido(Pedido pedido) {
		System.out.println("####################################################");
		System.out.println("# CADASTRAR PEDIDO	 							   #");
		System.out.println("####################################################");

		this.pedidos.add(pedido);
	}

	public void duplicarPedido(Pedido pedido) {
		System.out.println("####################################################");
		System.out.println("# DUPLICAR PEDIDO	 							   #");
		System.out.println("####################################################");

		this.pedidos.add(pedido);
	}

}
