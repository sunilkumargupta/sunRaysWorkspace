package com.sunRays.model;


import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunRays.util.Utility;


public class Test {
	

	
	public static void main(String[] args) {
		Address add1 = new Address();
		add1.setCity("Pune");
		add1.setStreet("Pimple");
		add1.setPinCode("411025");
		Customer cust1 = new Customer();
		cust1.setCustName("sun");
		cust1.setAddress(add1);
		
		
		Test test = new Test();
		test.save(cust1);
		
		test.showCustomers();
		
	}
	
	
	private void showCustomers() {
		SessionFactory sessionFactory = Utility.getSessionFactory();;
		if(sessionFactory != null){
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Customer> result = session.createQuery( "from Customer" ).list();
			Collections.sort(result);
			for ( Customer customer: result ) {
				System.out.println( customer);
			}
			session.getTransaction().commit();
			session.close();
		}
		Utility.closeSessionFactory();
	}
	private void save(Object customer) {
		
		SessionFactory sessionFactory = Utility.getSessionFactory();
		if(sessionFactory != null){
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save( customer );
			session.getTransaction().commit();
			session.close();
		}
		
		
	}
	
}
