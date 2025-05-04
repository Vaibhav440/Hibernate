package com.Hibernate.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = HibernateConfig.getSessionFactory();

		Session session = factory.openSession();

		Question question = new Question();
		question.setQuestion("What is java?");

		Answer answer = new Answer();
		answer.setAnswer("Java is Programming Lang!");
		answer.setQuestion(question);
		question.setAnswer(answer);

		Transaction txTransaction = session.beginTransaction();

		session.save(question);
		session.save(answer);

		txTransaction.commit();

		Transaction txTransaction1 = session.beginTransaction();

		Question que = session.get(Question.class, 1);
		System.out.println(que.getQuestion());
		System.out.println(que.getAnswer().getAnswer());

		txTransaction1.commit();

		session.close();

		System.out.println("Done!");

	}
}
