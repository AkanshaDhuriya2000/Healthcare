package com.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.Connection.ConnectionProvider;
import com.dao.JdbcDao.JdbcUserProfileDAO;

public class StreamAPI {

	public static void main(String[] args) {
		ArrayList<Integer>list=new ArrayList<Integer>();
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
		
		
//		 System.out.println(list.stream().mapToInt(map->map).sum());
		 
		 Connection connection = ConnectionProvider.getConnection();
		 JdbcUserProfileDAO user = new JdbcUserProfileDAO(connection);
		 

			ArrayList<UserProfile> userlist = user.getUserList();
			ArrayList<UserProfile> malelist = new ArrayList<UserProfile>();
			ArrayList<UserProfile> femalelist = new ArrayList<UserProfile>();

			for (UserProfile listitem : userlist) {
				if (listitem.getGender().equalsIgnoreCase("male")) {
					malelist.add(listitem);
				}
				if(listitem.getGender().equalsIgnoreCase("female")){
					femalelist.add(listitem);
				}
			}

			for (UserProfile listitem : malelist) {
				System.out.println(listitem.toString());
			}
			
			for (UserProfile listitem : femalelist) {
				System.out.println(listitem.toString());
			}
		 
		 
	 }

	}


