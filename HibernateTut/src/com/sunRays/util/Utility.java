package com.sunRays.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public enum Utility {
	_self;
	private SessionFactory sessionFactory;

	private Utility() {
	}
	protected void setUp1() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	protected void setUp() {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had
			// trouble building the SessionFactory
			// so destroy it manually.
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	    
	public static SessionFactory getSessionFactory() {
		prepareSessionFactory();
		return _self.sessionFactory;
	}

	public static void prepareSessionFactory() {
		if(_self.sessionFactory == null){
			_self.setUp();
		}
	}

	public static void closeSessionFactory() {
		if(_self.sessionFactory != null){
			_self.sessionFactory.close();
		}
		
	}
}
