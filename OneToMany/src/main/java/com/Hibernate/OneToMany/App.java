package com.Hibernate.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = HibernateConfig.getSessionFactory();

		Session session = factory.openSession();

		Employee employee=new Employee();
		employee.setName("Vaibhav");
		
		
		
		Account acc1 = new Account("IDBI", employee);
		Account acc2 = new Account("SBI", employee);

		List<Account> accounts = List.of(acc1, acc2);
		employee.setAccounts(accounts);
		

		Transaction txTransaction = session.beginTransaction();

		session.save(employee);
		session.save(acc1);
		session.save(acc2);
		


		txTransaction.commit();

		session.close();

		System.out.println("Done!");
    }
}
