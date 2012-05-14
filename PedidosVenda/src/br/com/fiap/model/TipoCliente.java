package br.com.fiap.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
@Table(name = "tipoCliente")
public class TipoCliente {
	
	@Id
    @GeneratedValue
    @Column(name = "idTipo")
	private long tipo;
	
	private String tipoCliente;
	
	@OneToMany(mappedBy = "tipoCliente", cascade=CascadeType.ALL)
	private Collection<Cliente> clientes;

	public long getTipo() {
		return tipo;
	}

	public void setTipo(long tipo) {
		this.tipo = tipo;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

}