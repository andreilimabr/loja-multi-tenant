package br.com.andreilima.lojamultitenant.pathresolver;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import br.com.andreilima.lojamultitenant.model.TemplateItem;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.http.FormatResolver;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.DefaultPathResolver;

@Component
@RequestScoped
public class CustomPathResolver extends DefaultPathResolver {
	
	private Result result;
	private HttpServletRequest request;
	
	public CustomPathResolver(FormatResolver resolver,Result result, HttpServletRequest request) {
		super(resolver);
		// TODO Auto-generated constructor stub
		this.result = result;
		this.request = request;
	}

	@Override
	public String pathFor(ResourceMethod method) {
		// TODO Auto-generated method stub
		String requestURI = this.request.getRequestURI();
		String path = new String();
		if ( ! requestURI.startsWith(this.request.getContextPath() + "/admin")) {
			Map<String, Object> included = this.result.included();
			TemplateItem templateItem = (TemplateItem)included.values().toArray()[0];
			path =  "/WEB-INF/templates/" + templateItem.getTemplate().getNome() + "." + getExtension();
		} else {
			path = super.pathFor(method);
		}
		return path;
	}
}
