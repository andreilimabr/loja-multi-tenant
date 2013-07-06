package br.com.andreilima.lojamultitenant.controle;

import java.util.List;

import br.com.andreilima.lojamultitenant.dao.DAO;
import br.com.andreilima.lojamultitenant.factory.EntityManagerCreator;
import br.com.andreilima.lojamultitenant.model.Imagens;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;


@Resource
public class HomeController {
	
	private EntityManagerCreator em;
	
	public HomeController(EntityManagerCreator em) {
		// TODO Auto-generated constructor stub
		this.em = em;
	}
	
	@Get("home")
	public List<Imagens> home(){
		DAO<Imagens> dao = new DAO<Imagens>(em.getInstance(),Imagens.class);
		return dao.getLista();
	}
			
	
}