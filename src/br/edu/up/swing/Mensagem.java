package br.edu.up.swing;

public class Mensagem {
	
	public static final String ERRO_OPCAO_INVALIDA = "Opção Inválida";
	
	public static final String ERRO_LOGIN_CLIENTE = "Senha ou Usuários inválidos";
	public static final String ERRO_BUSCA_CLIENTE = "Cliente não está cadastrado";
	public static final String ERRO_CADASTRAR_CLIENTE = "Erro ao cadastrar cliente";
	public static final String ERRO_ALTERAR_CLIENTE = "Erro ao alterar cliente";
	public static final String ERRO_BUSCAR_RESTAURANTE = "Opção de restaurante inválido";
	public static final String ERRO_BUSCAR_CARDAPIO = "Opção do cardápio inválida";
	public static final String ERRO_FORMA_PAGAMENTO = "Opção de Pagamento inválida";
	
	public static final String ERRO_LOGIN_ADMINISTRADOR = "Senha ou Usuários de administrador inválidos";
	public static final String ERRO_PEDIDOS_ADMINISTRADOR = "Senha ou Usuários de administrador inválidos";
	public static final String ERRO_CODIGO_RESTAURANTE = "Código de restaurante inválido";
	
	public static final String SUCESSO_REALIZACAO_PEDIDO = "Pedido realizado com sucesso !";
	public static final String SUCESSO_ENTREGA_PEDIDO = "Pedido entregue com sucesso !";
	public static final String ERRO_ENTREGA_PEDIDO = "Pedido não localizado !";
	
	public static void mensagemLog(String mensagemLog) {
		System.out.println("####################################################");
		System.out.println("# " +  mensagemLog);
		System.out.println("####################################################");
	}

}
