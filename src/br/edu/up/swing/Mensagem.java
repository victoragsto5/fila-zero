package br.edu.up.swing;

public class Mensagem {
	
	public static final String ERRO_OPCAO_INVALIDA = "Opção Inválida";
	
	public static final String ERRO_LOGIN_CLIENTE = "Senha ou Usuários inválidos";
	public static final String ERRO_BUSCA_CLIENTE = "Cliente não está cadastrado";
	
	public static void mensagemLog(String mensagemLog) {
		System.out.println("####################################################");
		System.out.println("# " +  mensagemLog);
		System.out.println("####################################################");
	}

}
