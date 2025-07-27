package com.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.practice.Repository.CourseRepository;
import com.practice.Utility.HibernateUtility;
//main class using switch
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	CourseRepository repo = new CourseRepository();
    	boolean run = false;
    	
    	System.out.println("------------------------Employee Directory---------------------------------------");
    	
    	while(!run) {
    		System.out.println("Which operation do You want to perform ? ");
    		System.out.println("1.Register for course ");
    		System.out.println("2.View all registrations ");
    		System.out.println("3.Update fees paid ");
    		System.out.println("4.Delete registration by id : ");
    		System.out.println("5.Exit ");
    	
    		//int choice = sc.nextInt();
    		int choice;
    	    try {
    	        choice = sc.nextInt();
    	    } catch (InputMismatchException e) {
    	        System.out.println("Plz enter valid input !! Only Numbers");
    	        sc.nextLine(); // Clear the buffer
    	        continue;
    	    }
    		switch(choice) {
    			
    		case 1:
    			repo.register(sc);
    			break;
    		case 2:
    			repo.viewall(sc);
    			break;
    		case 3:
    			repo.update(sc);
    			break;
    		case 4:
    			break;
    		case 5:
    			System.out.println("Exiting the application.................");
    			break;
    		default:
    			System.out.println("Invalid option!!!");
    		}
    	}
    }
}
