package br.com.andreilima.lojamultitenant.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private Tenant tenant;
	
	public JPAUtil(Tenant tenant) {
		// TODO Auto-generated constructor stub
		this.tenant = tenant;
	}
	public  EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(this.tenant.getNome());
		return factory.createEntityManager();
	}
}
