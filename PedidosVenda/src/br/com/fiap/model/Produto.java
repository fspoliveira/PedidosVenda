package br.com.fiap.model;


import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name = "idProduto")
	private long id;
    
    @Column(name = "descricaoProduto")
	private String descricao;
    
    @Column(name = "valorUnitarioProduto")
	private double valorUnitario;
    
    @OneToMany(mappedBy = "idProduto", cascade=CascadeType.ALL)
	private Collection<Venda> vendas;
    
    public Produto(){
    	
    }
    
	public Produto(long id) {
		super();
		this.id = id;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Collection<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Collection<Venda> vendas) {
		this.vendas = vendas;
	}

}