package br.com.fiap.dao;

import java.rmi.RemoteException;
import java.util.List;

import br.com.fiap.model.Venda;

public interface VendaDao {

	public void save(Venda venda);
    public Venda getVenda(long id);
    public List<Venda> list();
    public void remove(Venda venda);
    public void update(Venda venda); 
    public Integer getMaxPedidoVenda() throws RemoteException;
}