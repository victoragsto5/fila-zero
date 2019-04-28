package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.up.model.Pedido;

public class RestauranteController {

	private List<Pedido> pedidos;

	public RestauranteController() {
		this.pedidos = new ArrayList<Pedido>();
	}

	public void cadastrarPedido() {
		System.out.println("####################################################");
		System.out.println("# CADASTRAR PEDIDO	 							   #");
		System.out.println("####################################################");

		Pedido pedido = this.informarDadosPedido();
		this.pedidos.add(pedido);
	}

	public void duplicarPedido() {
		System.out.println("####################################################");
		System.out.println("# DUPLICAR PEDIDO	 							   #");
		System.out.println("####################################################");

		Pedido pedido = this.informarDadosPedido();
		this.pedidos.add(pedido);
	}

	private Pedido informarDadosPedido() {
		String produto = JOptionPane.showInputDialog(null, "Informe Nome:", "Cadastro Cliente",
				JOptionPane.QUESTION_MESSAGE);

		String valor = JOptionPane.showInputDialog(null, "Informe Número Identidade:", "Cadastro Cliente",
				JOptionPane.QUESTION_MESSAGE);

		Pedido pedido = new Pedido();

		return pedido;
	}

}
