package br.com.andreilima.lojamultitenant.controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class AdminController {
	
	private Result result;
	private ServletContext context;
	
	public AdminController(Result result, ServletContext context) {
		// TODO Auto-generated constructor stub
		this.result = result;
		this.context = context;
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
	   String path = this.context.getRealPath("/WEB-INF/templates");
		try {	
			// teste de merge
			// esta linha foi colocada propositalmente 
		    File file = new File(path +"/teste2.jsp");
			FileOutputStream os = new FileOutputStream(file);
			os.write(arquivo.getBytes());
			os.flush();
			os.close();
			System.out.println(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
