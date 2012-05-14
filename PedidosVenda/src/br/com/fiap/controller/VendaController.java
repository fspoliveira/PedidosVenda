package br.com.fiap.controller;

import br.com.fiap.dao.VendaDao;
import br.com.fiap.dao.VendaDaoImp;
import br.com.fiap.model.Venda;

public class VendaController {

	private Venda venda;

	public void adicionarVenda() {
		VendaDao dao = new VendaDaoImp();
		dao.save(venda);
	}
}