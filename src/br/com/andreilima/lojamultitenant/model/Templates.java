package br.com.andreilima.lojamultitenant.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Templates {
	@GeneratedValue
	@Id
	private int id;
	private String rota;
	private String nome;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="template")
	private List<TemplateItem> itens;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRota() {
		return rota;
	}
	public void setRota(String rota) {
		this.rota = rota;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<TemplateItem> getItens() {
		return itens;
	}
	public void setItens(List<TemplateItem> itens) {
		this.itens = itens;
	}

	
}
