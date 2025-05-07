package com.velox.HQL;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = HibernateConfig.getSessionFactory();


		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Query<String> createQuery = session.createQuery("SELECT b.name FROM Book b JOIN b.category c WHERE c.name LIKE 'S%'");
    //  createQuery.setParameter("bookName","Fiction");
		List<String> list = createQuery.list();
		for (String r : list) {
			 System.out.println(r);
		}



		transaction.commit();
		session.close();

	}
}
