package br.com.andreilima.lojamultitenant.controle;

import javax.servlet.http.HttpServletRequest;

import br.com.andreilima.lojamultitenant.dao.DAO;
import br.com.andreilima.lojamultitenant.factory.EntityManagerCreator;
import br.com.andreilima.lojamultitenant.model.TemplateItem;
import br.com.andreilima.lojamultitenant.model.Templates;
import br.com.andreilima.lojamultitenant.util.Tenant;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;


@Resource
public class HomeController {
	

	private HttpServletRequest req;
	private EntityManagerCreator em;
	private Result result;
	
	public HomeController(Tenant tenant, HttpServletRequest req,EntityManagerCreator em,Result result) {
		// TODO Auto-generated constructor stub
		this.req = req;
		this.em = em;
		this.result = result;
	}
	
	
	@Get("/home/*")
	public void root(){
		DAO<Templates> dao = new DAO<Templates>(em.getInstance(),Templates.class);
		String path = req.getRequestURI();
		Templates tenantTemplate = dao.buscaPorAtributo("rota", path);
		for (TemplateItem item : tenantTemplate.getItens()) {
			this.result.include(item.getNome(), item);
		}			
	}
	
	
}