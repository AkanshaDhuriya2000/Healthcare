package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasicStreamAPI {
	public static void main(String[] args) {
		List<Integer>list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		
		
		 
		// step1:convert it into from list to stream
		//step2:convert it from stream to filter
		//step 3:processed data ->collect
		//step4:collected data->list
		
		List<Integer> l1=list.stream().filter(obj-> obj%2==0).collect(Collectors.toList());
		System.out.println(l1);
		
		
		
		List<Student>studentList=new ArrayList<Student>();
		studentList.add(new Student(1,"Reshu",100));
		studentList.add(new Student(1,"Ashu",98));
		studentList.add(new Student(1,"Ankisha",200));
		studentList.add(new Student(1,"Mohnish",100));
		
		Student st=studentList.stream().filter(s->s.getMarks()==120).findFirst().orElse(new Student(0,null,0));
			Integer num=list.stream().filter(obj->obj=2).filterfirst().orElse(null);
	}
}
