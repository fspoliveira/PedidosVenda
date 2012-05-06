package br.com.fiap.controller;


import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import br.com.fiap.dao.ProdutoDaoImp;
import br.com.fiap.model.Produto;


public class ProdutoController {
	
	private SortedMap<String,String> produtos = new TreeMap<String,String>();
	
	 public SortedMap<String, String> getProdutos(){
	        List<Produto> tiposProdutos = new ProdutoDaoImp().list();
	        for(Produto tiposProduto: tiposProdutos ){
	        	produtos.put( String.valueOf(new Long(tiposProduto.getId())),tiposProduto.getDescricao());            
	        }
	        return produtos;
	    }
}
