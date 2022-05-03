package com.portotechstore.portotechstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="vendas")
public class VendaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private ProdutoModel produto;
	
	private String nomeProduto;
	
	@NotNull
	private int qtdeProduto;
	
	
	private double valorUnitarioProduto;
	@NotNull
	private double descontoProduto;
	
	@NotNull
	private double total;
	
	@NotNull
	private String formaPagamento;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteModel cliente;
	
	private String nomeCliente;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDateProduto = new java.sql.Date(System.currentTimeMillis());

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProdutoModel getProduto() {
		return produto;
	}

	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQtdeProduto() {
		return qtdeProduto;
	}

	public void setQtdeProduto(int qtdeProduto) {
		this.qtdeProduto = qtdeProduto;
	}

	public double getValorUnitarioProduto() {
		return valorUnitarioProduto;
	}

	public void setValorUnitarioProduto(double valorUnitarioProduto) {
		this.valorUnitarioProduto = valorUnitarioProduto;
	}

	public double getDescontoProduto() {
		return descontoProduto;
	}

	public void setDescontoProduto(double descontoProduto) {
		this.descontoProduto = descontoProduto;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Date getCreatedDateProduto() {
		return createdDateProduto;
	}

	public void setCreatedDateProduto(Date createdDateProduto) {
		this.createdDateProduto = createdDateProduto;
	}
	
}