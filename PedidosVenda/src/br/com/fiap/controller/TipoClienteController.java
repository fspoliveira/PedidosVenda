package br.com.fiap.controller;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import br.com.fiap.dao.TipoClienteDaoImp;
import br.com.fiap.model.TipoCliente;

public class TipoClienteController {

	private SortedMap<String, String> tipos = new TreeMap<String, String>();

	public SortedMap<String, String> getTipoClientes() {
		List<TipoCliente> tiposClientes = new TipoClienteDaoImp().list();
		for (TipoCliente tipoCliente : tiposClientes) {
			tipos.put(String.valueOf(new Long(tipoCliente.getTipo())),
					tipoCliente.getTipoCliente());
		}
		return tipos;
	}

}