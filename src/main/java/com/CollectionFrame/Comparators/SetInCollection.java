package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.model.Employee;

public class SetInCollection {
	public static void main(String[] args) {
		
		ArrayList<Integer>list=new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(1);
		System.out.println(list);
		
		Set<Integer>set=new HashSet<Integer>();
		set.add(2);
		set.add(1);
		set.add(1);
		set.add(1);
		set.add(1);
		System.out.println(set);
		
		Employee emp1=new Employee(1,"Mohnish",99);
		Employee emp2=new Employee(2,"Satyam",99);
		Set<Employee> setdata=new HashSet<Employee>();
		setdata.add(emp1);
		setdata.add(emp2);
		
		System.out.println(setdata.toString());

}
}
