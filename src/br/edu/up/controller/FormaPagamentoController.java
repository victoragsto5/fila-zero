package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.FormaPagamento;
import br.edu.up.model.Pedido;

public class FormaPagamentoController {
	
	private List<FormaPagamento> formasPagamento;
	
	public FormaPagamentoController() {
		
		List<FormaPagamento> formasPagamento = new ArrayList<FormaPagamento>(); 
		FormaPagamento formaPagamento1 = new FormaPagamento(1, "Dinheiro");
		FormaPagamento formaPagamento2 = new FormaPagamento(2, "Cartão");
		
		this.formasPagamento = formasPagamento;
		this.formasPagamento.add(formaPagamento1);
		this.formasPagamento.add(formaPagamento2);
		
	}
	
	public FormaPagamento buscaPorCodigo(String codigo) {
		
		if(this.formasPagamento.size() < 1) {
			return null;
		}
		
		for(FormaPagamento formaPagamento: this.formasPagamento) {
			if(formaPagamento.getCodigo().toString().equals(codigo)) {
				return formaPagamento;
			}
		}
		
		return null;
	}

	public String[] getOpcoesPagamento(Pedido pedido) {
		List<String> listaOpcoes = new ArrayList<String>();
		
		listaOpcoes.add("[VALOR TOTAL: " + pedido.getValorTotal() + "]");
		
		for(FormaPagamento formaPagamento : this.formasPagamento) {
			String opcao = this.getOpcaoPagamento(formaPagamento);
			listaOpcoes.add(opcao); 
		}
		
		String[] arrayOpcoes =  listaOpcoes.toArray(new String[0]);
		
		return arrayOpcoes;
	}

	private String getOpcaoPagamento(FormaPagamento formaPagamento) {
		return formaPagamento.getCodigo() + " - " + formaPagamento.getDescricao();
	}
	
}