package uk.co.novaware.seed.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class WsApplication extends Application {
	private static Logger log = LoggerFactory.getLogger(WsApplication.class);

	@Inject
	private BeanManager beanManager;
	private Set<Class<?>> restServices = new HashSet<Class<?>>();

	@PostConstruct
	public void locate() {
		log.info("Searching for rest components");

        Set<Bean<?>> beans = beanManager.getBeans(Object.class, DiscoveredRs.LITERAL);
        for (Bean<?> bean : beans) {
            Class<?> beanClass = bean.getBeanClass();
            log.debug("Registering rest service {}", beanClass);
            restServices.add(bean.getBeanClass());
        }
	}

	public Set<Class<?>> getClasses() {
		return restServices;
	}




}
