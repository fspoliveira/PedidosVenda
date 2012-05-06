/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.model.Cliente;
import java.util.List;

/**
 *
 * @author fsantiago
 */
public interface ClienteDao {
    
    public void save(Cliente cliente);
    public Cliente getCliente(long id);
    public List<Cliente> list();
    public void remove(Cliente convenio);
    public void update(Cliente convenio);
    
}
