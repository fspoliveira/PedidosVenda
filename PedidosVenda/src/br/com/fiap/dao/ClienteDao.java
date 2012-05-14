package br.com.fiap.dao;

import br.com.fiap.model.Cliente;
import java.util.List;

public interface ClienteDao {
    
    public void save(Cliente cliente);
    public Cliente getCliente(long id);
    public List<Cliente> list();
    public void remove(Cliente cliente);
    public void update(Cliente cliente);    
}