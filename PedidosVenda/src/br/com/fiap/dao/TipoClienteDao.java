package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.model.TipoCliente;

public interface TipoClienteDao {
	
	 public void save(TipoCliente tipo);
	    public TipoCliente getTipoCliente(long id);
	    public List<TipoCliente> list();
	    public void remove(TipoCliente tipo);
	    public void update(TipoCliente tipo);
}