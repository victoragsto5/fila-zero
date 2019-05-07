package br.edu.up.controller;

import java.util.List;

import br.edu.up.model.Pedido;
import br.edu.up.model.Produto;

public class PedidoController {

	
	public static void calculaTotalPedido(Pedido pedido) {
		
		Double valorTotal = 0.0;
		List<Produto> produtos = pedido.getProdutos();
		
		for(Produto produto : produtos) {
			valorTotal = valorTotal + produto.getPreco();
		}
		
		pedido.setValorTotal(valorTotal);
	}
	
}