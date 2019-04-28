package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Cliente;
import br.edu.up.swing.Mensagem;

public class ClienteController {
	
	private List<Cliente> clientesCadastrados;
	
	public ClienteController() {
		this.clientesCadastrados = new ArrayList<Cliente>();
	}
	
	public void cadastrar(Cliente cliente) {
		if(cliente.getId() != null) {
			Mensagem.mensagemLog("CADASTRAR CLIENTE");
			
			Integer idCliente = this.clientesCadastrados.size();
			cliente.setId(idCliente);
			this.clientesCadastrados.add(cliente);
		} else {
			Mensagem.mensagemLog("ALTERAR CLIENTE");
			
			Integer indice = cliente.getId() - 1;
			this.clientesCadastrados.set(indice, cliente);
		}
		
	}
	
	public Cliente buscarPorLoginSenha(String login, String senha) {
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
	
}
