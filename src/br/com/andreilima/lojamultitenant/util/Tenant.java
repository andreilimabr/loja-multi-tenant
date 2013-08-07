package br.com.andreilima.lojamultitenant.util;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

@RequestScoped
@Component
public class Tenant {
	private String nome;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	
	
}
