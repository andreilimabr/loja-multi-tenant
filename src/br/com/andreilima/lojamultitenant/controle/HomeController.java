package br.com.andreilima.lojamultitenant.controle;

import javax.servlet.http.HttpServletRequest;

import br.com.andreilima.lojamultitenant.dao.DAO;
import br.com.andreilima.lojamultitenant.factory.EntityManagerCreator;
import br.com.andreilima.lojamultitenant.model.Templates;
import br.com.andreilima.lojamultitenant.util.Tenant;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;


@Resource
public class HomeController {
	

	private HttpServletRequest req;
	private EntityManagerCreator em;
	
	public HomeController(Tenant tenant, HttpServletRequest req,EntityManagerCreator em) {
		// TODO Auto-generated constructor stub
		this.req = req;
		this.em = em;
	}
	
	
	@Get("/*")
	public Templates root(){
		DAO<Templates> dao = new DAO<Templates>(em.getInstance(),Templates.class);
		String path = req.getRequestURI();
		Templates tenantTemplate = dao.buscaPorAtributo("rota", path);
		
		return tenantTemplate;
	}
	
	
}