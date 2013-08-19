package br.com.andreilima.lojamultitenant.interceptor;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import br.com.andreilima.lojamultitenant.util.Tenant;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
@RequestScoped
public class RequisicaoInterceptor implements Interceptor {

	private final Tenant tenant;
	private final HttpServletRequest request;
	
	public RequisicaoInterceptor(Tenant tenant, HttpServletRequest request) {
		// TODO Auto-generated constructor stub
		this.tenant = tenant;
		this.request = request;
	}
	
	@Override
	public boolean accepts(ResourceMethod method) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object object) throws InterceptionException {
		// TODO Auto-generated method stub
		this.resolveTenantName(request);
		stack.next(method, object);
	}
	
	
	public void resolveTenantName(HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL(request.getRequestURL().toString());
			String serverName = url.getHost();
			int ponto = serverName.indexOf(".")+1;
			String tenantName = serverName.substring(ponto,serverName.indexOf(".", ponto));
			this.tenant.setNome(tenantName);
		} catch (MalformedURLException e){
			e.printStackTrace();
		}
	}
	
}
