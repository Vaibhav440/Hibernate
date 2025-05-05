package com.nt.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ManyToMany.Course;
import ManyToMany.Student;
import OneToMany_ManyToOne.Account;
import OneToMany_ManyToOne.EmployeeOne;



public class TestApp {

    public static void main(String agr[]) {
    	
        SessionFactory factory = HibernateConfig.getSessionFactory(); 

//        Addreess addreess=new Addreess();
//        addreess.setAddress("Pune");
//        
//        
//        Employee employee=new Employee();
//        employee.setName("Vaibhav");
//        employee.setContact("8421158508");
//        employee.setAddreess(addreess);
//        addreess.setEmployee(employee);
        
        
//        
//        EmployeeOne employeeOne=new EmployeeOne();
//        employeeOne.setName("Vaibhav");
//        
//        Account account=new Account();
//        account.setName("IDFC");
//        account.setEmployeeOne(employeeOne);
//        
//        Account account1=new Account();
//        account1.setName("IDBI");
//        account1.setEmployeeOne(employeeOne);
//        
//        List<Account> list=new ArrayList<Account>();
//        list.add(account);
//        list.add(account1);
//        
//        employeeOne.setAccount(list);
        
        
     // Create students
        Student student = new Student();
        student.setName("Vaibhav");

        Student student1 = new Student();
        student1.setName("Om");

        Student student2 = new Student();
        student2.setName("Sai");

        // Create courses
        Course course = new Course();
        course.setName("Java");

        Course course1 = new Course();
        course1.setName("Spring");

        Course course2 = new Course();
        course2.setName("SpringBoot");

        Course course3 = new Course();
        course3.setName("php");

        // Assign courses to students
        List<Course> coursesForVaibhav = new ArrayList<Course>();
        coursesForVaibhav.add(course);
        coursesForVaibhav.add(course1);
        coursesForVaibhav.add(course3);

        List<Course> coursesForOm = new ArrayList<Course>();
        coursesForOm.add(course1);
        coursesForOm.add(course2);
        coursesForOm.add(course3);

        List<Course> coursesForSai = new ArrayList<Course>();
        coursesForSai.add(course);
        coursesForSai.add(course3);

        student.setCourses(coursesForVaibhav);
        student1.setCourses(coursesForOm);
        student2.setCourses(coursesForSai);

        // Assign students to courses
        List<Student> studentsForCourseJava = new ArrayList<Student>();
        studentsForCourseJava.add(student);
        studentsForCourseJava.add(student2);

        List<Student> studentsForCourseSpring = new ArrayList<Student>();
        studentsForCourseSpring.add(student);
        studentsForCourseSpring.add(student1);

        List<Student> studentsForCourseSpringBoot = new ArrayList<Student>();
        studentsForCourseSpringBoot.add(student1);

        List<Student> studentsForCoursePhp = new ArrayList<Student>();
        studentsForCoursePhp.add(student);
        studentsForCoursePhp.add(student1);
        studentsForCoursePhp.add(student2);

        course.setStudents(studentsForCourseJava);
        course1.setStudents(studentsForCourseSpring);
        course2.setStudents(studentsForCourseSpringBoot);
        course3.setStudents(studentsForCoursePhp);
        
        
        
        Session session = factory.openSession(); 
        Transaction beTransaction = session.beginTransaction(); 
//
//        session.save(addreess);
//        session.save(employee);
        
      //  session.save(employeeOne);
      //  session.save(account);
      //  session.save(account1);       //beacuse of Cascade no need to perform this operations
        
        

        session.save(student);
        session.save(student1);
        session.save(student2);

        session.save(course);
        session.save(course1);
        session.save(course2);
        session.save(course3);
    
        beTransaction.commit();
        session.close(); 

        System.out.println("Record saved successfully.");
    }

}
