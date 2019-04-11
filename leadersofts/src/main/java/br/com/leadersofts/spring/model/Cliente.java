package br.com.leadersofts.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Persistência do objeto para o DB.
 * 
 */

@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT s FROM Cliente s")
public class Cliente implements Serializable {
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNascto() {
		return nascto;
	}

	public void setNascto(String nascto) {
		this.nascto = nascto;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	
	private boolean firstAttempt;
	
	@Id
	private int id_cliente;

	@Size(min=3, max=30)
	private String nome;
	
	@NotEmpty
	private String cpf;
	
	@NotEmpty	
	private String nascto;
	
	@Size(min=3, max=30)
	private Double peso;

	@NotEmpty
	private String UF;
	
	
	@NotEmpty
	private List<String> subjects = new ArrayList<String>();

	 public boolean isFirstAttempt() {
	        return firstAttempt;
	 }
	 
	 public void setFirstAttempt(boolean firstAttempt) {
		 this.firstAttempt = firstAttempt;
	 }
	
	

}