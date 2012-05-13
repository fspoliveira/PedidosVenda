package br.com.fiap.controller;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import br.com.fiap.dao.ClienteDaoImp;
import br.com.fiap.model.Cliente;

public class ClienteController {

	private SortedMap<String, String> clientes = new TreeMap<String, String>();

	public SortedMap<String, String> getClientes() {
		List<Cliente> tiposClientes = new ClienteDaoImp().list();
		for (Cliente tiposCliente : tiposClientes) {
			clientes.put(String.valueOf(new Long(tiposCliente.getId())),
					tiposCliente.getNomeFantasia());
		}
		return clientes;
	}
}