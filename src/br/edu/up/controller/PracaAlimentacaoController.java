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
			this.menuLogin();
			break;
		case "2":
			this.menuCliente();
			break;
		default:
			MenuController.exibeMensagem(Mensagem.ERRO_OPCAO_INVALIDA, Titulo.PRINCIPAL, JOptionPane.ERROR_MESSAGE);
			this.menuInicial();
			break;
		}

	}

	private void menuLogin() {

		String login = MenuController.entradaDados("Login", Titulo.LOGIN);
		String senha = MenuController.entradaDados("Senha:", Titulo.LOGIN);

		Cliente clienteLogado = this.clienteController.buscarPorLoginSenha(login, senha);

		if (clienteLogado != null) {
			this.menuPedido(clienteLogado);
		} else {
			MenuController.exibeMensagemErro(Mensagem.ERRO_LOGIN_CLIENTE, Titulo.LOGIN);
			this.menuInicial();
		}
	}

	private void menuCliente() {

		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(Opcoes.MENU_CLIENTE, Titulo.CLIENTE);

		switch (opcaoEscolhida) {
		case "1":
			this.menuNovoCliente();
			break;
		case "2":
			this.menuAlterarCliente();
			break;
		default:
			this.menuCliente();
			break;
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

	private void menuPedido(Cliente cliente) {

		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(Opcoes.MENU_PEDIDO, Titulo.PEDIDO);

		switch (opcaoEscolhida) {
		case "1":
			this.restauranteController.cadastrarPedido();
			break;
		case "2":
			this.restauranteController.duplicarPedido();
			break;
		default:
			this.menuPedido(cliente);
			break;
		}
	}

}
