package br.edu.up.controller;

import javax.swing.JOptionPane;

import br.edu.up.model.Administrador;
import br.edu.up.model.Cliente;
import br.edu.up.model.Pedido;
import br.edu.up.model.Produto;
import br.edu.up.model.Restaurante;
import br.edu.up.swing.Mensagem;
import br.edu.up.swing.Opcoes;
import br.edu.up.swing.Titulo;

public class PracaAlimentacaoController {

	private RestauranteController restauranteController;
	private ClienteController clienteController;
	private FormaPagamentoController formaPagamentoController;
	private AdministradorController administradorController;

	public PracaAlimentacaoController() {
		this.clienteController = new ClienteController();
		this.restauranteController = new RestauranteController();
		this.formaPagamentoController = new FormaPagamentoController();
		this.administradorController = new AdministradorController();
	}

	public void iniciarSistema() {
		menuInicial();
	}

	private void menuInicial() {

		String opcaoSelecionada = MenuController.entradaDadosComOpcoes(Opcoes.MENU_INICIAL, Titulo.PRINCIPAL);

		switch (opcaoSelecionada) {
		case "1":
			this.menuInicialCliente();
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
	private void menuInicialCliente() {

		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(Opcoes.MENU_INICIAL_CLIENTE, Titulo.CLIENTE);

		switch (opcaoEscolhida) {
		case "1":
			this.menuLoginCliente();
			break;
		case "2":
			this.menuNovoCliente();
			break;
		case "0":
			this.menuInicial();
			break;
		default:
			MenuController.exibeMensagemErro(Mensagem.ERRO_OPCAO_INVALIDA, Titulo.CLIENTE);
			this.menuInicialCliente();
			break;
		}
	}
	
	private void menuLoginCliente() {

		String login = MenuController.entradaDados("Login", Titulo.LOGIN);
		String senha = MenuController.entradaDados("Senha:", Titulo.LOGIN);

		Cliente clienteLogado = this.clienteController.buscarPorLoginSenha(login, senha);

		if (clienteLogado != null) {
			this.menuClienteLogado(clienteLogado);
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
			this.menuInicialCliente();
		} else {
			MenuController.exibeMensagemErro("Login já cadastrado", Titulo.CLIENTE);
			this.menuNovoCliente();
		}
	
	}
	
	private void menuAlterarCliente(Cliente cliente) {
		
		String tituloClienteLogado = Titulo.CLIENTE + ": " + cliente.getNome();
		Cliente clienteAlterar = this.clienteController.buscarPorLogin(cliente.getLogin());
		
		if(clienteAlterar != null) {
			String nome = MenuController.entradaDadosPreenchidos("Informe o Nome:", tituloClienteLogado, clienteAlterar.getNome());
			String rg = MenuController.entradaDadosPreenchidos("Informe o Número Identidade:", tituloClienteLogado, clienteAlterar.getRg());
			String cpf = MenuController.entradaDadosPreenchidos("Informe o CPF:", tituloClienteLogado, clienteAlterar.getCpf());
			String endereco = MenuController.entradaDadosPreenchidos("Informe um Endereço:", tituloClienteLogado, clienteAlterar.getEndereco());
			String telefone = MenuController.entradaDadosPreenchidos("Informe um Telefone:", tituloClienteLogado, clienteAlterar.getTelefone());
			
			clienteAlterar.setNome(nome);
			clienteAlterar.setRg(rg);
			clienteAlterar.setCpf(cpf);
			clienteAlterar.setEndereco(endereco);
			clienteAlterar.setTelefone(telefone);
			
			this.clienteController.cadastrar(clienteAlterar);
			this.menuClienteLogado(clienteAlterar);
			
		} else {
			MenuController.exibeMensagemErro(Mensagem.ERRO_ALTERAR_CLIENTE, Titulo.CLIENTE);
			this.menuInicialCliente();
		}
	}

	/**
	 * ######################################################################
	 * # PEDIDO
	 * ######################################################################
	 */
	private void menuClienteLogado(Cliente cliente) {

		String tituloClienteLogado = Titulo.CLIENTE + ": " + cliente.getNome();
		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(Opcoes.MENU_CLIENTE, tituloClienteLogado);

		switch (opcaoEscolhida) {
		case "1":
			this.menuPedidoCliente(cliente);
			break;
		case "2":
			this.menuAlterarCliente(cliente);
			break;
		case "0":
			this.menuInicial();
			break;
		default:
			MenuController.exibeMensagemErro(Mensagem.ERRO_OPCAO_INVALIDA, Titulo.CLIENTE);
			this.menuClienteLogado(cliente);
			break;
		}
	}

	private void menuPedidoCliente(Cliente cliente) {
		
		String tituloClienteLogado = Titulo.CLIENTE + ": " + cliente.getNome();
		String[] opcoes = restauranteController.getOpcoesRestaurante();
		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(opcoes, tituloClienteLogado);
		
		Restaurante restaurante = this.restauranteController.buscaRestaurantePorCodigo(opcaoEscolhida);
		
		if(restaurante != null) {
			Pedido pedido = new Pedido();
			pedido.setCliente(cliente);
			pedido.setRestaurante(restaurante);
			this.menuCardapio(pedido);
		} else {
			MenuController.exibeMensagemErro(Mensagem.ERRO_BUSCAR_RESTAURANTE, tituloClienteLogado);
			this.menuPedidoCliente(cliente);
		} 
		
	}
	
	private void menuCardapio(Pedido pedido) {
		
		Cliente cliente = pedido.getCliente();
		Restaurante restaurante = pedido.getRestaurante();
		
		String tituloClienteLogado = Titulo.CLIENTE + ": " + cliente.getNome();
		String[] opcoes = restauranteController.getOpcoesCardapio(restaurante);
		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(opcoes, tituloClienteLogado);
		
		if(opcaoEscolhida.equals("0")) {
			this.menuFormaPagamento(pedido);
		}
		
		Produto produto = this.restauranteController.buscaNoCardapio(restaurante, opcaoEscolhida);
		
		if(produto != null) {
			
			String mensagemQuantidadeProduto = "Informe a quantidade de " + produto.getDescricao() + " :";
			String quantidadeInformada = MenuController.entradaDados(mensagemQuantidadeProduto, tituloClienteLogado);
			
			Integer quantidade = Integer.valueOf(quantidadeInformada);
			
			for(int i = 0; i < quantidade; i++) {
				pedido.getProdutos().add(produto);
			}
			
			this.menuCardapio(pedido);
		} else {
			MenuController.exibeMensagemErro(Mensagem.ERRO_BUSCAR_CARDAPIO, tituloClienteLogado);
			this.menuCardapio(pedido);
		} 
	}
	
	private void menuFormaPagamento(Pedido pedido) {
		
		PedidoController.calculaTotalPedido(pedido);
		
		String tituloClienteLogado = Titulo.CLIENTE + ": " + pedido.getCliente().getNome();
		String[] opcoes = formaPagamentoController.getOpcoesPagamento(pedido);
		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(opcoes, tituloClienteLogado);
		
		switch (opcaoEscolhida) {
		case "1":			
			this.administradorController.receberPedido(pedido);
			this.restauranteController.receberPedido(pedido);
			MenuController.exibeMensagemInformacao(Mensagem.SUCESSO_REALIZACAO_PEDIDO, tituloClienteLogado);			
			this.menuInicial();
			break;
		case "2":
			this.administradorController.receberPedido(pedido);
			this.restauranteController.receberPedido(pedido);
			MenuController.exibeMensagemInformacao(Mensagem.SUCESSO_REALIZACAO_PEDIDO, tituloClienteLogado);
			this.menuInicial();
			break;
		default:
			MenuController.exibeMensagemErro(Mensagem.ERRO_FORMA_PAGAMENTO, tituloClienteLogado);
			this.menuFormaPagamento(pedido);
			break;
		}
	}
	
//	private void menuTroco() {
//		
//	}
//	
//	private void menuDuplicarPedido(Cliente cliente) {
//		
//	}
	
	/**
	 * ######################################################################
	 * # ADMINISTRADOR
	 * ######################################################################
	 */
	private void menuAdministrador() {
		
		String login = MenuController.entradaDados("Login Administrador", Titulo.ADMINISTRADOR);
		String senha = MenuController.entradaDados("Senha Administrador:", Titulo.ADMINISTRADOR);

		Administrador administradorLogado = this.administradorController.loginAdministrador(login, senha);

		if (administradorLogado != null) {
			this.menuAdministradorLogado(administradorLogado);
		} else {
			MenuController.exibeMensagemErro(Mensagem.ERRO_LOGIN_ADMINISTRADOR, Titulo.ADMINISTRADOR);
			this.menuInicial();
		}
	}
	
	private void menuAdministradorLogado(Administrador administradorLogado) {
		
		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(Opcoes.MENU_ADMINISTRADOR, Titulo.ADMINISTRADOR);
		
		switch (opcaoEscolhida) {
		case "1":			
			this.menuPedidosAdministrador(administradorLogado);
			break;
		case "0":			
			this.menuInicial();
			break;
		default:
			MenuController.exibeMensagemErro(Mensagem.ERRO_OPCAO_INVALIDA, Titulo.ADMINISTRADOR);
			this.menuAdministradorLogado(administradorLogado);
			break;
		}
		
	}
	
	private void menuPedidosAdministrador(Administrador administrador) {
		String[] opcoes = this.administradorController.getOpcoesPedidos();
		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(opcoes, Titulo.ADMINISTRADOR);
		
		switch (opcaoEscolhida) {
		case "0":			
			this.menuAdministradorLogado(administrador);
			break;
		default:
			MenuController.exibeMensagemErro(Mensagem.ERRO_OPCAO_INVALIDA, Titulo.ADMINISTRADOR);
			this.menuAdministradorLogado(administrador);
			break;
		}
	}

	private void menuRestaurante() {
	
		String codigo = MenuController.entradaDados("Informe o Código Restaurante", Titulo.RESTAURANTE);

		Restaurante restaurante = this.restauranteController.buscaRestaurantePorCodigo(codigo);

		if (restaurante != null) {
			this.menuInicialRestaurante(restaurante);
		} else {
			MenuController.exibeMensagemErro(Mensagem.ERRO_CODIGO_RESTAURANTE, Titulo.RESTAURANTE);
			this.menuInicial();
		}
	}

	private void menuInicialRestaurante(Restaurante restaurante) {
		
		String tituloRestaurante = Titulo.RESTAURANTE + ": " + restaurante.getNome();
		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(Opcoes.MENU_RESTAURANTE, tituloRestaurante);

		switch (opcaoEscolhida) {
		case "1":
			this.menuPedidosRestaurante(restaurante);
			break;
		case "2":
			this.menuEntregarPedido(restaurante);
			break;
		case "0":
			this.menuInicial();
			break;
		default:
			MenuController.exibeMensagemErro(Mensagem.ERRO_OPCAO_INVALIDA, Titulo.RESTAURANTE);
			this.menuInicialRestaurante(restaurante);
			break;
		}
		
	}

	private void menuEntregarPedido(Restaurante restaurante) {

		String tituloRestaurante = Titulo.RESTAURANTE + ": " + restaurante.getNome();
		String[] opcoes = this.restauranteController.getOpcoesPedidos(restaurante);
		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(opcoes, tituloRestaurante);
		
		Pedido pedidoEntregue = this.restauranteController.entregarPedido(restaurante, opcaoEscolhida);
		
		if(pedidoEntregue != null) {
			this.administradorController.entregarPedido(opcaoEscolhida);
			MenuController.exibeMensagemInformacao("Pedido: " + pedidoEntregue.getCodigo() + 
					"\nCliente: " + pedidoEntregue.getCliente().getNome() + 
					"\n" + Mensagem.SUCESSO_ENTREGA_PEDIDO , tituloRestaurante);
			this.menuInicialRestaurante(restaurante);
		} else {
			MenuController.exibeMensagemErro(Mensagem.ERRO_ENTREGA_PEDIDO, tituloRestaurante);
			this.menuInicialRestaurante(restaurante);
		}

		
		
	}

	private void menuPedidosRestaurante(Restaurante restaurante) {
		
		String tituloRestaurante = Titulo.RESTAURANTE + ": " + restaurante.getNome();
		String[] opcoes = this.restauranteController.getOpcoesPedidos(restaurante);
		String opcaoEscolhida = MenuController.entradaDadosComOpcoes(opcoes, tituloRestaurante);
		
		switch (opcaoEscolhida) {
		case "0":
			this.menuInicialRestaurante(restaurante);
			break;
		default:
			MenuController.exibeMensagemErro(Mensagem.ERRO_OPCAO_INVALIDA, tituloRestaurante);
			this.menuInicialRestaurante(restaurante);
			break;
		}
		
	}

}
