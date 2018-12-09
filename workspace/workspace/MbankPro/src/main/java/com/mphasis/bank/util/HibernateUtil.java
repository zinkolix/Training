/**
 * Hibernate Util class build the session factory.
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {

		// Creating a configuration object
		Configuration configuration = new Configuration().configure();

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		// Building a session factory object with the parent class Configuration
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

}
