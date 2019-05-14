package br.edu.up.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.up.model.Administrador;
import br.edu.up.model.Pedido;
import br.edu.up.swing.Opcoes;

public class AdministradorController {
	
	private Integer uid = 1;
	private List<Pedido> pedidos;
	private List<Pedido> pedidosEntregues;

	public AdministradorController() {
		this.pedidos = new ArrayList<Pedido>();
		this.pedidosEntregues = new ArrayList<Pedido>();
	}

	public Administrador loginAdministrador(String login, String senha) {
		if(login.equals("admin") && senha.equals("admin")) {
			return new Administrador(1, login, senha);
		}
		
		return null;
	}
	
	public String[] getOpcoesPedidos() {
		
		List<Pedido> listaPedidos = this.pedidos;
		List<String> listaOpcoes = new ArrayList<String>();
		
		listaOpcoes.add(Opcoes.SEPARADOR);
		listaOpcoes.add("LISTA PEDIDOS - ADMINISTRADOR");
		listaOpcoes.add(Opcoes.SEPARADOR);
		
		for(Pedido pedido : listaPedidos) {
			String opcao = this.getOpcaoPedido(pedido);
			listaOpcoes.add(opcao);
			listaOpcoes.add("--------------------------------------------------");
		}
		
		listaOpcoes.add(Opcoes.SEPARADOR);
		listaOpcoes.add("0 - Voltar");
		listaOpcoes.add(Opcoes.SEPARADOR);
		
		String[] arrayOpcoes = listaOpcoes.toArray(new String[0]);
		
		return arrayOpcoes;
	}
	
	private String getOpcaoPedido(Pedido pedido) {
		return pedido.getCodigo() + " - " + 
				pedido.getRestaurante().getNome() + " - " + 
				pedido.getCliente().getNome() + " - " + 
				pedido.getValorTotal();
	}
	
	public Pedido receberPedido(Pedido pedido) {
		pedido.setCodigo(uid);
		pedido.setDataPedido(new Date());
		this.pedidos.add(pedido);
		
		this.uid++;
		
		return pedido;
	}
	
	public Pedido entregarPedido(String codigo) {
		
		for(int i = 0;i  < this.pedidos.size(); i++) {
			Pedido pedido = this.pedidos.get(i);
			if(pedido.getCodigo().toString().equals(codigo)) {
				Pedido pedidoEntregue = this.pedidos.remove(i);
				this.pedidosEntregues.add(pedidoEntregue);
				return pedido;
			}
		}
		
		return null;
	}

}
