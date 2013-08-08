package br.com.andreilima.lojamultitenant.controle;

import org.apache.shiro.SecurityUtils;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class AdminController {
	
	private Result result;
	
	public AdminController(Result result) {
		// TODO Auto-generated constructor stub
		this.result = result;
	}
	
	@Path("/admin/painel")
	public void painel(){
		System.out.println("passou por aqui");
	}
	
	@Path("/admin/login")
	public void login(){
		
	}
	
	@Path("/admin/logout")
	public void logout(){
		SecurityUtils.getSubject().logout();
		this.result.forwardTo(HomeController.class).root();
		
	}
	
	@Path("/admin/unauthorized")
	public void unauthorized() {
		System.out.println("Acesso nao autorizado");
	}
}
