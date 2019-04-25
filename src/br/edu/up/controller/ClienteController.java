package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.up.model.Cliente;

public class ClienteController {
	
	private List<Cliente> clientesCadastrados;
	
	public ClienteController() {
		this.clientesCadastrados = new ArrayList<Cliente>();
	}
	
	public void cadastrar() {
		System.out.println("####################################################");
		System.out.println("# CADASTRAR CLIENTES 							   #");
		System.out.println("####################################################");
		
		Cliente cliente = this.obterDadosCliente();
		this.clientesCadastrados.add(cliente);
	}
	
	public void alterar() {
		System.out.println("####################################################");
		System.out.println("# ALTERAR CLIENTES 								   #");
		System.out.println("####################################################");
	}
	
	public Cliente login() {
		System.out.println("####################################################");
		System.out.println("# DUPLICAR CLIENTES 							   #");
		System.out.println("####################################################");
		
		String login = JOptionPane.showInputDialog(null, "Login:", "Login Cliente",
				JOptionPane.QUESTION_MESSAGE);

		String senha = JOptionPane.showInputDialog(null, "Senha:", "Login Cliente",
				JOptionPane.QUESTION_MESSAGE);
		
		for(Cliente cliente : this.clientesCadastrados) {
			if(cliente.getLogin().equals(login) && cliente.getSenha().equals(senha)) {
				return cliente;
			}
		}
		
		return null;
	}
	
	private Cliente obterDadosCliente() {
		String nome = JOptionPane.showInputDialog(null, "Informe Nome:", "Cadastro Cliente",
	            JOptionPane.QUESTION_MESSAGE);

		String rg = JOptionPane.showInputDialog(null, "Informe Número Identidade:", "Cadastro Cliente",
				JOptionPane.QUESTION_MESSAGE);

		String cpf = JOptionPane.showInputDialog(null, "Informe o CPF:", "Cadastro Cliente",
				JOptionPane.QUESTION_MESSAGE);

		String endereco = JOptionPane.showInputDialog(null, "Informe um Endereço:", "Cadastro Cliente",
				JOptionPane.QUESTION_MESSAGE);

		String login = JOptionPane.showInputDialog(null, "Informe um Login:", "Cadastro Cliente",
				JOptionPane.QUESTION_MESSAGE);

		String senha = JOptionPane.showInputDialog(null, "Informe uma Senha:", "Cadastro Cliente",
				JOptionPane.QUESTION_MESSAGE);
		
		Cliente cliente = new Cliente();
		
		cliente.setNome(nome);
		cliente.setRg(rg);
		cliente.setCpf(cpf);
		cliente.setEndereço(endereco);
		cliente.setLogin(login);
		cliente.setSenha(senha);
		
		return cliente;
	}
}
