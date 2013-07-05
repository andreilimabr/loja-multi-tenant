package br.com.andreilima.lojamultitenant.controle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import br.com.andreilima.lojamultitenant.dao.DAO;
import br.com.andreilima.lojamultitenant.model.Imagens;
import br.com.andreilima.lojamultitenant.util.JPAUtil;
import br.com.andreilima.lojamultitenant.util.Tenant;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;



@Resource
public class HomeController {
	private Tenant tenant;
	private HttpServletRequest request;
	public HomeController(Tenant tenant, HttpServletRequest request) {
		// TODO Auto-generated constructor stub
		this.tenant = tenant;
		this.request = request;
	}
	
	@Get("home")
	public List<Imagens> home(){
		this.resolveTenantName(request);
		EntityManager em = new JPAUtil(tenant).getEntityManager();
		DAO<Imagens> dao = new DAO<Imagens>(em,Imagens.class);
		return dao.getLista();
	}
	
	
	

	public void resolveTenantName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String serverName = request.getServerName();
		String tenantName = serverName.substring(0, serverName.indexOf("."));
		if (this.tenant.getNome() == null){
			this.tenant.setNome(tenantName);
		} else {
			if (this.tenant.getNome() != tenantName ){
				this.tenant.setNome(tenantName);
			}	
		}	
	}
	
	
}