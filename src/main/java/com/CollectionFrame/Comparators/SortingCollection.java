package com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortingCollection {

	public static void main(String[] args) {
		  
		
		Student s1=new Student(1,"Reshma",59);
		Student s2=new Student(3,"Monish",69);
		Student s3=new Student(4,"Akansha",79);
		Student s4=new Student(2,"Shruti",89);
		Student s5=new Student(5,"Savi",99);
		ArrayList<Student>list=new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		
		for(Student student:list) {
			System.out.println(student.toString());
		}
		 System.out.println("sorting initatied");
		Collections.sort(list);
		
		for(Student student:list) {
			System.out.println(student.toString());
		}
		/******************Sorting by Comparators*************/
		System.out.println("sorting Student is by Id........");
		Collections.sort(list,new SortById() );
		
		for(Student student:list);
		System.out.println(student.toString());
	}
	     System.out.println("sorting Student by name......");
	      Collections.sort(list,new SortByName());
	
             /****Sort using inner class****/
	      Collections.sort(list,new Comparator<Student>() {
	    	  @Override
	    	  public int compare(Student o1,Student o2) {
	    		  return (int)(o1.getMarks()-o2.getMarks());
	    	  }
          });
	      //*****using lambda****//
	      Collections.sort(list,(o1,o2)->{
	    	  return(int)(o1.getMarks()-o2.getMarks());
	      }
	    );
	      for(Student student:list) {
	      System.out.println(student.toString());
	      }
    }
