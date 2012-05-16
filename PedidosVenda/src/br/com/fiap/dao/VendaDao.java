package br.com.fiap.dao;


import java.net.ConnectException;
import java.rmi.RemoteException;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import br.com.fiap.model.Venda;

public interface VendaDao {

	public void save(Venda venda);
    public Venda getVenda(long id);
    public List<Venda> list();
    public void remove(Venda venda);
    public void update(Venda venda); 
    public Integer getMaxPedidoVenda() throws  ConnectException;
}