package br.com.fiap.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendas")
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name = "numPedido")
	private long id;
	
	private Date dataPedido;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente idCliente;
	
	@ManyToOne
	@JoinColumn(name="idProduto")
	private Produto idProduto;
	
	private int quantidade;
	private double valorUnitario;
	private double desconto;
	private double total;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	public Produto getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
