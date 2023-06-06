package com.Controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Connection.ConnectionProvider;
import com.dao.UserProfileDAO;
import com.dao.JdbcDao.JdbcUserProfileDAO;
import com.model.UserProfile;

public class UserRegistrationController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response) {
		
		Connection connection = null;
		
		try {
			
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String fullname = firstname+" "+lastname;
			String address = request.getParameter("address");
			String contact = request.getParameter("contact");
			String emailid = request.getParameter("email");
			String gender = request.getParameter("gender");
			String stateid = request.getParameter("stateid");
			String cityid = request.getParameter("cityid");
			String date_of_birth = request.getParameter("dob");
			String userid = request.getParameter("userid");
			String password = request.getParameter("password");
		
			UserProfile user = new UserProfile();
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setFullname(fullname);
			user.setAddress(address);
			user.setContact(contact);
			user.setEmail(emailid);
			user.setUserid(userid);
			user.setGender(gender);
			user.setPassword(password);
			user.setDob(date_of_birth);
			user.setStateid(Integer.parseInt(stateid));
			user.setCityid(Integer.parseInt(cityid));
			
			 LocalDateTime now = LocalDateTime.now();
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			 String formattedDateTime = now.format(formatter);
			 
			 user.setReg_date(formattedDateTime);
			 user.setLast_modified(formattedDateTime);
			
			connection = ConnectionProvider.getConnection();
			UserProfileDAO userProfileDAO = new JdbcUserProfileDAO(connection);
			int status =  userProfileDAO.saveUser(user);
			
			if(status == 1)
			{
				status = userProfileDAO.saveUserCreds(userid,password);
				if(status == 1)
				{
					RequestDispatcher rd = request.getRequestDispatcher("pages/login.jsp");
					rd.include(request, response);
					//**executing runnable thread for capturing
					//*use operation log
					Runnable log=()->{
						
						userProfileDAO.saveUserOperationLog(user);
						
					};
					Thread t=new Thread(log);
					t.start();				}
				else
				{
					PrintWriter out = response.getWriter();
					out.append("<b>Failed to register ,please try after sometime...</b>");
					RequestDispatcher rd = request.getRequestDispatcher("/registrationform");
					rd.include(request,response);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
