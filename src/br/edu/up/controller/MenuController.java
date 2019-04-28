package br.edu.up.controller;

import javax.swing.JOptionPane;

public class MenuController {
	
	public static String entradaDadosComOpcoes(String[] opcoes, String titulo) {
		String opcoesStr = getOpcoesStr(opcoes);
		return JOptionPane.showInputDialog(null, opcoesStr, titulo, JOptionPane.QUESTION_MESSAGE);
	}
	
	public static String entradaDados(String opcoes, String titulo) {
		return JOptionPane.showInputDialog(null, opcoes, titulo, JOptionPane.QUESTION_MESSAGE);
	}

	public static void exibeMensagem(String mensagem, String tituloMenu, Integer tipoMensagem) {
		JOptionPane.showMessageDialog(null, mensagem, tituloMenu, tipoMensagem);
	}

	public static void exibeMensagemErro(String mensagem, String tituloMenu) {
		JOptionPane.showMessageDialog(null, mensagem, tituloMenu, JOptionPane.ERROR_MESSAGE);
	}

	public static void exibeMensagemAlerta(String mensagem, String tituloMenu) {
		JOptionPane.showMessageDialog(null, mensagem, tituloMenu, JOptionPane.WARNING_MESSAGE);
	}

	public static void exibeMensagemQuestao(String mensagem, String tituloMenu) {
		JOptionPane.showMessageDialog(null, mensagem, tituloMenu, JOptionPane.QUESTION_MESSAGE);
	}

	public static void exibeMensagemInformacao(String mensagem, String tituloMenu) {
		JOptionPane.showMessageDialog(null, mensagem, tituloMenu, JOptionPane.INFORMATION_MESSAGE);
	}

	private static String getOpcoesStr(String[] opcoes) {

		String opcoesStr = null;

		for (String opcao : opcoes) {
			opcoesStr = opcoesStr + opcao + "\n";
		}

		return opcoesStr;
	}

}
