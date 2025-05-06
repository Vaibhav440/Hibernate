package com.velox.HibernateObjectState;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
       SessionFactory factory=HibernateConfig.getSessionFactory();
       
       //Transient State -->Object is created using new does not asscociate with Session and Database.
       
       Product product=new Product();
       product.setName("iphone");
       
       Session session=factory.openSession();
       Transaction transaction=session.beginTransaction(); //--->To Physically chnages in DB
       
       session.save(product);  //Persistent State-:Object is associate with Session and store in DB
                               //All the Chnages in Object directly reflect in DB and Session Object because they are Shrink.
       transaction.commit();
       session.close();
       
       //When we close the session then object goes in detach state here onwords any chnages in object not reflect in DB
       //To perform Any operation again establish the connection.
       
       Session session1=factory.openSession();
       Transaction transaction1=session1.beginTransaction();
       
       session1.delete(product); //delete the given object from DB .
       
       transaction1.commit();
       session1.close();
       
       
       
    }
}
