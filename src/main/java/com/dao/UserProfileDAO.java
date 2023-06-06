package com.dao;

import java.util.ArrayList;

import com.model.UserProfile;

public interface UserProfileDAO {

    public ArrayList<UserProfile> getUserList();
	
	public int saveUser(UserProfile user);
	
	public int updateUser(UserProfile user);
	
	public UserProfile findUserById(int id);
	
	public boolean checkUserCreds(String userid,String password);
	
	public int saveUserCreds(String userid,String password);

	public void saveUserOperationLog(UserProfile user);
	
}
