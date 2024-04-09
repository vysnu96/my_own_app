package com.webapp.signup;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.management.loading.PrivateClassLoader;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String jdbcurl="jdbc:mysql://localhost:3306/signupsignin";
	private String jdbcUsername="root";
	private String jdbcPassword="root";
	Connection con=null;
	int rs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String firstName=request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try 
		{
			con=DriverManager.getConnection(jdbcurl,jdbcUsername,jdbcPassword);
			
			String query ="insert into signup(FirstName,LastName,Email,Password) values(?,?,?,?)";
			
			PreparedStatement preparestatement=con.prepareStatement(query);
			
			preparestatement.setString(1, firstName);
			preparestatement.setString(2, lastName);
			preparestatement.setString(3, email);
			preparestatement.setString(4, password);
			
			rs = preparestatement.executeUpdate();
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			if(rs > 0) {
				request.getSession().setAttribute("firstname", firstName);	
				response.sendRedirect("Welcome.jsp");
				}
			else {
				request.getRequestDispatcher("SignUp.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
