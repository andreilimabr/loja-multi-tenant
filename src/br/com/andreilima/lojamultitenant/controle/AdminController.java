package br.com.andreilima.lojamultitenant.controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
		
	}
	
	@Path("/admin/login")
	public void login(){
		
	}
	
	@Path("/admin/logout")
	public void logout(){
		SecurityUtils.getSubject().logout();
		this.result.forwardTo(this).login();
		
	}
	
	@Path("/admin/unauthorized")
	public void unauthorized() {
		System.out.println("Acesso nao autorizado");
	}
	
	@Path("/admin/templates")
	public void templates() {
		
	}
	
	@Path("/admin/savetemplate")
	public void savetemplate(String arquivo) {
		// salva o arquivo
		
		try {		
		    File file = new File("/Users/aclima/workspace/loja-multi-tenant/WebContent/WEB-INF/templates/teste.jsp");
			FileOutputStream os = new FileOutputStream(file);
			os.write(arquivo.getBytes());
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
