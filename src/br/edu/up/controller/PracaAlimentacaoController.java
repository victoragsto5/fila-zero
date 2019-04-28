package br.edu.up.controller;

import javax.swing.JOptionPane;

import br.edu.up.model.Cliente;
import br.edu.up.swing.Mensagem;
import br.edu.up.swing.Opcoes;
import br.edu.up.swing.Titulo;

public class PracaAlimentacaoController {

	private RestauranteController restauranteController;
	private ClienteController clienteController;

	public PracaAlimentacaoController() {
		this.clienteController = new ClienteController();
		this.restauranteController = new RestauranteController();
	}

	public void iniciarSistema() {
		menuInicial();
	}

	private void menuInicial() {

		String opcaoSelecionada = MenuController.entradaDadosComOpcoes(Opcoes.MENU_INICIAL, Titulo.PRINCIPAL);

		switch (opcaoSelecionada) {
		case "1":
			this.menuCliente();
			break;
		case "2":
			this.menuRestaurante();
			break;
		case "3":
			this.menuAdministrador();
			break;
		default:
			MenuController.exibeMensagem(Mensagem.ERRO_OPCAO_INVALIDA, Titulo.PRINCIPAL, JOptionPane.ERROR_MESSAGE);
			this.menuInicial();
			break;
		}

	}

	/**
	 * ######################################################################
	 * # CLIENTE
	 * ######################################################################
	 */
	private void menuCliente() {

		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(Opcoes.MENU_CLIENTE, Titulo.CLIENTE);

		switch (opcaoEscolhida) {
		case "1":
			this.menuLoginCliente();
			break;
		case "2":
			this.menuNovoCliente();
			break;
		case "3":
			this.menuAlterarCliente();
			break;
		default:
			this.menuCliente();
			break;
		}
	}
	
	private void menuLoginCliente() {

		String login = MenuController.entradaDados("Login", Titulo.LOGIN);
		String senha = MenuController.entradaDados("Senha:", Titulo.LOGIN);

		Cliente clienteLogado = this.clienteController.buscarPorLoginSenha(login, senha);

		if (clienteLogado != null) {
			this.menuPedidoCliente(clienteLogado);
		} else {
			MenuController.exibeMensagemErro(Mensagem.ERRO_LOGIN_CLIENTE, Titulo.LOGIN);
			this.menuInicial();
		}
	}
	
	private void menuNovoCliente() {
		String nome = MenuController.entradaDados("Informe o Nome:", Titulo.CLIENTE);
		String rg = MenuController.entradaDados("Informe o Número Identidade:", Titulo.CLIENTE);
		String cpf = MenuController.entradaDados("Informe o CPF:", Titulo.CLIENTE);
		String endereco = MenuController.entradaDados("Informe um Endereço:", Titulo.CLIENTE);
		String telefone = MenuController.entradaDados("Informe um Telefone:", Titulo.CLIENTE);
		String login = MenuController.entradaDados("Informe um Login:", Titulo.CLIENTE);
		String senha = MenuController.entradaDados("Informe uma Senha:", Titulo.CLIENTE);
		
		Cliente clienteCadastrado = this.clienteController.buscarPorLoginSenha(login, senha);
		
		if(clienteCadastrado == null) {
			Cliente cliente = new Cliente(nome, rg, cpf, endereco, telefone, login, senha);
			this.clienteController.cadastrar(cliente);
		} else {
			this.menuNovoCliente();
		}
	
	}
	
	private void menuAlterarCliente() {
		String login = MenuController.entradaDados("Buscar por Login:", Titulo.CLIENTE);
		Cliente clienteAlterar = this.clienteController.buscarPorLogin(login);
		
		if(clienteAlterar != null) {
			String nome = MenuController.entradaDados("Informe o Nome:", Titulo.CLIENTE);
			String rg = MenuController.entradaDados("Informe o Número Identidade:", Titulo.CLIENTE);
			String cpf = MenuController.entradaDados("Informe o CPF:", Titulo.CLIENTE);
			String endereco = MenuController.entradaDados("Informe um Endereço:", Titulo.CLIENTE);
			String telefone = MenuController.entradaDados("Informe um Telefone:", Titulo.CLIENTE);
			
			clienteAlterar.setNome(nome);
			clienteAlterar.setRg(rg);
			clienteAlterar.setCpf(cpf);
			clienteAlterar.setEndereço(endereco);
			clienteAlterar.setTelefone(telefone);
			
			this.clienteController.cadastrar(clienteAlterar);
			this.menuCliente();
			
		} else {
			MenuController.exibeMensagemErro(Mensagem.ERRO_LOGIN_CLIENTE, Titulo.CLIENTE);
		}
	}

	/**
	 * ######################################################################
	 * # PEDIDO
	 * ######################################################################
	 */
	private void menuPedidoCliente(Cliente cliente) {

		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(Opcoes.MENU_PEDIDO, Titulo.PEDIDO);

		switch (opcaoEscolhida) {
		case "1":
			this.menuNovoPedido();
			break;
		case "2":
			this.menuDuplicarPedido();
			break;
		default:
			this.menuPedidoCliente(cliente);
			break;
		}
	}
	
	private void menuNovoPedido() {
		
	}
	
	private void menuDuplicarPedido() {
		
	}
	
	/**
	 * ######################################################################
	 * # RESTAURANTE
	 * ######################################################################
	 */
	private void menuRestaurante() {
		
		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(Opcoes.MENU_RESTAURANTE, Titulo.RESTAURANTE);
		
		switch (opcaoEscolhida) {
		case "1":
			Mensagem.mensagemLog("EXIBIR MENU RESTAURANTE");
			break;
		default:
			this.menuRestaurante();
			break;
		}
	}
	
	/**
	 * ######################################################################
	 * # ADMINISTRADOR
	 * ######################################################################
	 */
	private void menuAdministrador() {
		
		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(Opcoes.MENU_ADMINISTRADOR, Titulo.ADMINISTRADOR);
		
		switch (opcaoEscolhida) {
		case "1":
			Mensagem.mensagemLog("EXIBIR MENU ADMINISTRADOR");
			break;
		default:
			this.menuAdministrador();
			break;
		}
	}

}
