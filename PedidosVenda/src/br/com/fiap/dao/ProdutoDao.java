package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.model.Produto;


public interface ProdutoDao {
	
	public void save(Produto produto);
    public Produto getProduto(long id);
    public List<Produto> list();
    public void remove(Produto produto);
    public void update(Produto produto);
}