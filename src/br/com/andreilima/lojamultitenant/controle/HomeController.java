package br.com.andreilima.lojamultitenant.controle;

import javax.servlet.http.HttpServletRequest;

import br.com.andreilima.lojamultitenant.dao.DAO;
import br.com.andreilima.lojamultitenant.factory.EntityManagerCreator;
import br.com.andreilima.lojamultitenant.model.Templates;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;


@Resource
public class HomeController {
	
	private EntityManagerCreator em;
	private HttpServletRequest request;
	private Result result;
	
	public HomeController(EntityManagerCreator em, HttpServletRequest request, Result result) {
		// TODO Auto-generated constructor stub
		this.em = em;
		this.request = request;
		this.result = result;
	}
	
	@Get("/*")
	public void home(){
		DAO<Templates> dao = new DAO<Templates>(em.getInstance(),Templates.class);
		String addr = this.request.getRequestURI();
		Templates templates = dao.buscaPorAtributo("rota", addr);
		this.result.forwardTo(templates.getTemplate());
	}
			
	
}