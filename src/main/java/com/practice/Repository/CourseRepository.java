package com.practice.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practice.Entity.CourseDetails;
import com.practice.Utility.HibernateUtility;

public class CourseRepository {
	CourseDetails course = new CourseDetails();

	//register for course
	public void register(Scanner sc) {
		System.out.println("Enter student name : ");
		sc.nextLine();
		String stuname = sc.nextLine();
		System.out.println("Enter course name :");
		String coursename = sc.nextLine();
		System.out.println("Fees paid : ");
		double feespaid = sc.nextDouble();
		sc.nextLine();
		
		LocalDate date = LocalDate.now();
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	course.setStuname(stuname);
    	course.setCoursename(coursename);
    	course.setRegDate(date);
    	course.setFeespaid(feespaid);
    	
    	session.persist(course);
    	transaction.commit();
    	session.close();
    	
    	System.out.println("Registerd for course : ");
		
	}
	
	//View all
	public void viewall(Scanner sc) {
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	List<CourseDetails> clist = session.createQuery("select c from CourseDetails c ",CourseDetails.class).getResultList();
    	clist.stream().forEach(a->System.out.println(a.toString()));
    	
    	transaction.commit();
    	session.close();
	}
	
	//update fees paid
	public void update(Scanner sc) {
		System.out.println("Enter id of course to update the fees : ");
		int id = sc.nextInt();
		
		SessionFactory factory = HibernateUtility.getSessionFactory();
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	CourseDetails cou = session.find(CourseDetails.class, id);
    	System.out.println("Enter updated fees paid : ");
    	double fees = sc.nextDouble();
    	
    	course.setFeespaid(fees);
    	transaction.commit();
    	session.close();
    	System.out.println("Fees updated");
	}
	
	//delete by id
	public void delete(Scanner sc) {
		System.out.println("Enter id to delete its registration :");
		int id = sc.nextInt();
		SessionFactory factory = HibernateUtility.getSessionFactory();
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	CourseDetails cou = session.find(CourseDetails.class, id);
    	session.remove(cou);
    	transaction.commit();
    	session.close();
    	
    	System.out.println("Registration deleted");
		
		
	}
}
