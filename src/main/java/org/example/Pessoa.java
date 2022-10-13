package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "pessoa" )
public class Pessoa {
	private Long id;
	private String nome;
	private String cpf;
	private String datanascimento;
	private String contato;
	
	public Pessoa() {
		//O Hibernate necessita de um construtor sem parametros
	}	
	
	public Pessoa(String nome, String cpf, String datanascimento, String contato) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.datanascimento = datanascimento;
		this.contato = contato;
	}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return datanascimento;
	}
	public void setDataNascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	
	
}
