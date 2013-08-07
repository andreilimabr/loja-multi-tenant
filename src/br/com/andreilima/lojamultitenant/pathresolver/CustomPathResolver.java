package br.com.andreilima.lojamultitenant.pathresolver;

import java.util.Map;

import br.com.andreilima.lojamultitenant.model.Templates;
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
	
	public CustomPathResolver(FormatResolver resolver,Result result) {
		super(resolver);
		// TODO Auto-generated constructor stub
		this.result = result;
	}

	@Override
	public String pathFor(ResourceMethod method) {
		// TODO Auto-generated method stub
		
		Map<String, Object> included = this.result.included();
		Templates template = (Templates)included.get("templates");
		String path =  "/WEB-INF/templates/" + template.getNome() + "." + getExtension();
		return path;
	}
}
