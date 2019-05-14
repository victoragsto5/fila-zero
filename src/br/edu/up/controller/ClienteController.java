package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Cliente;

public class ClienteController {
	
	private List<Cliente> clientesCadastrados;
	
	public ClienteController() {
		this.clientesCadastrados = new ArrayList<Cliente>();
		this.initializeClientes();
	}
	
	public void cadastrar(Cliente cliente) {
		if(cliente.getId() == null) {
			Integer idCliente = this.clientesCadastrados.size() + 1;
			cliente.setId(idCliente);
			this.clientesCadastrados.add(cliente);
		} else {
			Integer indice = cliente.getId() - 1;
			this.clientesCadastrados.set(indice, cliente);
		}
		
	}
	
	public Cliente buscarPorLoginSenha(String login, String senha) {
		
		if(this.clientesCadastrados.size() < 1) {
			return null;
		}
		
		for(Cliente cliente : this.clientesCadastrados) {
			if(cliente.getLogin().equals(login) && cliente.getSenha().equals(senha)) {
				return cliente;
			}
		}
		return null;
	}
	
	public Cliente buscarPorLogin(String login) {
		for(Cliente cliente : this.clientesCadastrados) {
			if(cliente.getLogin().equals(login)) {
				return cliente;
			}
		}
		return null;
	}
	
	private void initializeClientes() {
		String nome = "Victor Auguto de Paula";
		String rg = "10.264.193.0";
		String cpf = "101.264.193-02";
		String endereco = "Rua Teste 1100";
		String telefone = "(41)7777-8888";
		String login = "cloud";
		String senha = "123";
		
		Cliente cliente = new Cliente(nome, rg, cpf, endereco, telefone, login, senha);
		
		this.clientesCadastrados.add(cliente);
	}
	
}
