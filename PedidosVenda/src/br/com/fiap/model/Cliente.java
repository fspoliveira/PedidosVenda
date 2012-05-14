package br.com.fiap.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name = "idCliente")
	private long id;
 
	private String nomeFantasia;
	
	@ManyToOne
	@JoinColumn(name="idTipoCliente")
	private TipoCliente tipoCliente;
	
	@OneToMany(mappedBy = "idCliente", cascade=CascadeType.ALL)
	private Collection<Venda> vendas;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public Collection<Venda> getVendas() {
		return vendas;
	}
	public void setVendas(Collection<Venda> vendas) {
		this.vendas = vendas;
	}
}