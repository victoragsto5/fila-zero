package br.edu.up.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Produto;

public class CardapioController {
	
	public static List<Produto> initializeCardapioJapones() {
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		Produto produto1 = new Produto(1, "Sushi", 20.00);
		Produto produto2 = new Produto(2, "Sashimi", 15.00);
		Produto produto3 = new Produto(3, "Sakê", 10.00);
		
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		
		return produtos;
	}
	
	public static List<Produto> initializeCardapioHamburgueria() {
		List<Produto> produtos = new ArrayList<Produto>();
		
		Produto produto1 = new Produto(1, "X-Burguer", 20.00);
		Produto produto2 = new Produto(2, "Batata Frita", 10.00);
		Produto produto3 = new Produto(3, "Refrigerante", 5.00);
		Produto produto4 = new Produto(4, "Chopp", 5.00);
		
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);
		
		return produtos;
	}
	
	public static List<Produto> initializeCardapioPizzaria() {
		List<Produto> produtos = new ArrayList<Produto>();
		
		Produto produto1 = new Produto(1, "Pizza", 40.00);
		Produto produto2 = new Produto(2, "Calzone", 20.00);
		Produto produto3 = new Produto(3, "Refrigerante", 5.00);
		Produto produto4 = new Produto(4, "Cerveja", 10.00);
		
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);
		
		return produtos;
	}
	
}
