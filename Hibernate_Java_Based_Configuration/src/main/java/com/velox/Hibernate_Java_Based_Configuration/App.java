package com.velox.Hibernate_Java_Based_Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory1=HibernateSeessionFactory.getSessionFactory();
        
        // Create an Employee object
        EmployeeTest employee = new EmployeeTest(102, "Om", "Dev");
        
        Session openSession = factory1.openSession();
        Transaction beginTransaction=openSession.beginTransaction();
        openSession.save(employee);
        beginTransaction.commit();
        openSession.close();
        
        System.out.println("Done!");
        

    }
    
}
