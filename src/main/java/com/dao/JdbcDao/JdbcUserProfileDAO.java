package com.dao.JdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.Connection.JDBCBaseDAO;
import com.dao.UserProfileDAO;
import com.model.UserProfile;

public class JdbcUserProfileDAO extends JDBCBaseDAO implements UserProfileDAO {

	public JdbcUserProfileDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public ArrayList<UserProfile> getUserList() {

		ArrayList<UserProfile> userlist = new ArrayList<UserProfile>();

		try {
			StringBuffer sqlQuery = new StringBuffer();

			sqlQuery.append(
					"SELECT id,firstname,lastname,fullname,address,contact,gender,stateid,cityid,email,dob,reg_date,last_modified,isadmin FROM user_details;");
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserProfile user = new UserProfile();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setFullname(rs.getString("fullname"));
				user.setAddress(rs.getString("address"));
				user.setContact(rs.getString("contact"));
				user.setGender(rs.getString("gender"));
				user.setStateid(rs.getInt("stateid"));
				user.setCityid(rs.getInt("cityid"));
				user.setEmail(rs.getString("email"));
				user.setDob(rs.getString("dob"));
				user.setReg_date(rs.getString("reg_date"));
				user.setLast_modified(rs.getString("last_modified"));
				user.setIsadmin(rs.getInt("isadmin"));

				userlist.add(user);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userlist;
	}

	@Override
	public int saveUser(UserProfile user) {
		int response = 0;

		try {

			StringBuffer sqlQuery = new StringBuffer();
			sqlQuery.append("INSERT INTO user_details ");
			sqlQuery.append(
					"(firstname,lastname,fullname,address,contact,gender,stateid,cityid,email,dob,reg_date,last_modified,isadmin) ");
			sqlQuery.append("VALUES ");
			sqlQuery.append("(?,?,?,?,?,?,?,?,?,?,?,?,?); ");
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString(),Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getContact());
			ps.setString(6, user.getGender());
			ps.setInt(7, user.getStateid());
			ps.setInt(8, user.getCityid());
			ps.setString(9, user.getEmail());
			ps.setString(10, user.getDob());
			ps.setString(11, user.getReg_date());
			ps.setString(12, user.getLast_modified());
			ps.setInt(13, user.getIsadmin());
			response = ps.executeUpdate();
			if(response==1) {
				ResultSet rs=ps.getGeneratedKeys();
				response=rs.next()==true?rs.getInt(1):0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public int updateUser(UserProfile user) {
		int response=0;
		try
		{
			 StringBuffer sqlQuery = new StringBuffer(); 
		        sqlQuery.append("UPDATE user_details SET ");
		        sqlQuery.append("firstname=?, lastname=?, fullname=?, address=?, contact=?, gender=?, stateid=?, cityid=?, email=?, dob=?, last_modified=?, isadmin=? ");
		        sqlQuery.append("WHERE id=?");
		        PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
		        ps.setString(1, user.getFirstname());
		        ps.setString(2, user.getLastname());
		        ps.setString(3, user.getFullname());
		        ps.setString(4, user.getAddress());
		        ps.setString(5, user.getContact());
		        ps.setString(6, user.getGender());
		        ps.setInt(7, user.getStateid());
		        ps.setInt(8, user.getCityid());
		        ps.setString(9, user.getEmail());
		        ps.setString(10, user.getDob());
		        ps.setString(11, user.getLast_modified());
		        ps.setInt(12, user.getIsadmin());
		        ps.setInt(13, user.getId());
		        response = ps.executeUpdate();	
		}
		catch (Exception e) {
			System.out.println(e);
		}	
		return response;
	}

	@Override
	public UserProfile findUserById(int id) {
		UserProfile user = new UserProfile();
		try {
			StringBuffer sqlQuery = new StringBuffer();
			sqlQuery.append(
					"SELECT id,firstname,lastname,fullname,address,contact,gender,stateid,cityid,email,dob,reg_date,last_modified,isadmin FROM user_details WHERE id=?;");
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setAddress(rs.getString("address"));
				user.setContact(rs.getString("contact"));
				user.setGender(rs.getString("gender"));
				user.setStateid(rs.getInt("stateid"));
				user.setCityid(rs.getInt("cityid"));
				user.setEmail(rs.getString("email"));
				user.setDob(rs.getString("dob"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public boolean checkUserCreds(String userid, String password) {
		boolean response = false;

		try {
			StringBuffer sqlQuery = new StringBuffer();
			sqlQuery.append("SELECT id FROM user_creds ");
			sqlQuery.append("WHERE userid=? AND password=?;");
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ps.setString(1, userid);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			response = rs.next() ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public int saveUserCreds(String userid, String password) {
		int response = 0;

		try {
			String sqlQuery = "INSERT INTO user_creds (userid,password) VALUES (?,?);";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, userid);
			ps.setString(2, password);
			response = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public void saveUserOperationLog(UserProfile user) {
		
		
	}

}