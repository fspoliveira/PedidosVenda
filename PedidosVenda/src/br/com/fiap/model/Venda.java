package br.com.fiap.model;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendas")
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id  
    @Column(name = "numPedido")
	private Integer id;
	
	@Id  
	@Column(name = "linha")
	private Integer linha;
	
	private GregorianCalendar dataPedido;
	
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
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public GregorianCalendar getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(GregorianCalendar dataPedido) {
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
	
	public Integer getLinha() {
		return linha;
	}
	public void setLinha(Integer linha) {
		this.linha = linha;
	}
	
}