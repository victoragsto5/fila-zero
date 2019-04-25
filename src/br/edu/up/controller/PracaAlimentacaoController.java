package br.edu.up.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.edu.up.model.Cliente;

public class PracaAlimentacaoController {
	
	private RestauranteController restauranteController;
	private ClienteController clienteController;
	
	public PracaAlimentacaoController() {
		this.clienteController = new ClienteController();
		this.restauranteController = new RestauranteController();
	}
	
	public void iniciarSistema() {
		exibirMenuPrincipal();
	}
	
	private void exibirMenuPrincipal() {

		JFrame frame = new JFrame();
		String[] opcoes = {"1 - Login", "2 - Cadastro"};
		String opcaoEscolhida = (String) JOptionPane.showInputDialog(frame, "Escolha uma opção", "Menu Principal", JOptionPane.QUESTION_MESSAGE,
				null, opcoes, null);
		
		Integer opcaoValor = Integer.valueOf(opcaoEscolhida.substring(0,1));
		
		switch (opcaoValor) {
		case 1:
			this.subMenuLogin();
			break;
		case 2:
			this.subMenuCadastro();
			break;
		default:
			this.exibirMenuPrincipal();
			break;
		}
	}
	
	private void subMenuLogin() {
		
		Cliente clienteLogado = this.clienteController.login();
		
		if(clienteLogado != null) {
			this.subMenuPedido(clienteLogado);
		} else {
			this.exibeMsgUsuarioInvalido();
		}
		
		this.exibirMenuPrincipal();
	}
	
	private void subMenuCadastro() {
		JFrame frame = new JFrame();
		String[] opcoes = {"1 - Novo", "2 - Alterar"};
		String opcaoEscolhida = (String) JOptionPane.showInputDialog(frame, "Escolha uma opção", "Menu Cliente", JOptionPane.QUESTION_MESSAGE,
				null, opcoes, null);
		
		Integer opcaoValor = Integer.valueOf(opcaoEscolhida.substring(0,1));
		
		switch (opcaoValor) {
		case 1:
			this.clienteController.cadastrar();
			break;
		case 2:
			this.clienteController.alterar();
			break;
		default:
			break;
		}
		
		this.exibirMenuPrincipal();
	}
	
	private void subMenuPedido(Cliente cliente) {
		
		JFrame frame = new JFrame();
		String[] opcoes = {"1 - Cadastrar Pedido", "2 - Duplicar Pedido"};
		String opcaoEscolhida = (String) JOptionPane.showInputDialog(frame, "Escolha uma opção", "Menu Pedido", JOptionPane.QUESTION_MESSAGE,
				null, opcoes, null);
		Integer opcaoValor = Integer.valueOf(opcaoEscolhida.substring(0,1));
		
		switch (opcaoValor) {
		case 1:
			this.restauranteController.cadastrarPedido();
			break;
		case 2:
			this.restauranteController.duplicarPedido();
			break;
		default:
			break;
		}
		
		this.subMenuPedido(cliente);
	}
	
	private void exibeMsgUsuarioInvalido() {
	    JOptionPane.showMessageDialog(null, "Senha ou Usuários inválidos", "Login", JOptionPane.ERROR_MESSAGE, null);;
	}

}
