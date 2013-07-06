package br.com.andreilima.lojamultitenant.factory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.internal.util.ValueHolder;
import org.hibernate.mapping.PropertyGeneration;
import org.hibernate.metamodel.source.LocalBindingContext;
import org.hibernate.metamodel.source.binder.AttributeSource;
import org.hibernate.metamodel.source.binder.ComponentAttributeSource;
import org.hibernate.metamodel.source.binder.ExplicitHibernateTypeSource;
import org.hibernate.metamodel.source.binder.MetaAttributeSource;
import org.hibernate.metamodel.source.binder.RelationalValueSource;
import org.hibernate.metamodel.source.binder.SingularAttributeNature;

import br.com.andreilima.lojamultitenant.util.Tenant;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class EntityManagerCreator implements ComponentFactory<EntityManager>,
		ComponentAttributeSource {

	private Tenant tenant;
	
	
	public EntityManagerCreator(Tenant tenant) {
		// TODO Auto-generated constructor stub
		this.tenant = tenant;
	}
	
	@Override
	public PropertyGeneration getGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SingularAttributeNature getNature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInsertable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLazy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUpdatable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVirtualAttribute() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPropertyAccessorName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExplicitHibernateTypeSource getTypeInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isIncludedInOptimisticLocking() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSingular() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<MetaAttributeSource> metaAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areValuesIncludedInInsertByDefault() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean areValuesIncludedInUpdateByDefault() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean areValuesNullableByDefault() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RelationalValueSource> relationalValueSources() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<AttributeSource> attributeSources() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalBindingContext getLocalBindingContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValueHolder<Class<?>> getClassReference() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExplicitTuplizerClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParentReferenceAttributeName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityManager getInstance() {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(this.tenant.getNome());
		return factory.createEntityManager();
	}

}
