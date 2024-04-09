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
import java.sql.SQLException;

/**
 * Servlet implementation class SignIn
 */
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String jdbcurl="jdbc:mysql://localhost:3306/signupsignin";
	private String jdbcUsername="root";
	private String jdbcPassword="root";
	Connection con=null;
	ResultSet rs=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
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
		
			try {
				con=DriverManager.getConnection(jdbcurl,jdbcUsername,jdbcPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String query="select * from signup where Email=? and Password=?";
			
			
			try {
				PreparedStatement preparestatement=con.prepareStatement(query);
				preparestatement.setString(1, email);
				preparestatement.setString(2, password);
				
				rs = preparestatement.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(rs.next()) {
					request.getSession().setAttribute("email", email);
					response.sendRedirect("user.jsp");
				}
					else {
						request.getRequestDispatcher("SignIn.jsp").forward(request, response);
					}
				}
			 catch (Exception e) {
				// TODO: handle exception
			}
	}

}
