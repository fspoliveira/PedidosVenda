package br.com.fiap.controller;

import java.net.ConnectException;
import br.com.fiap.dao.VendaDao;
import br.com.fiap.dao.VendaDaoImp;
import br.com.fiap.model.Venda;

public class VendaController {

	private Venda venda;

	public VendaController() {

	}

	public VendaController(Venda venda) {
		super();
		this.venda = venda;
	}

	public void adicionarVenda() {
		VendaDao dao = new VendaDaoImp();
		dao.save(venda);
	}
	
	public Integer GetProximoPedido() throws ConnectException{
		VendaDao dao = new VendaDaoImp();
		return dao.getMaxPedidoVenda();
	}
}