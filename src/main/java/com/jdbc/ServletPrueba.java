package com.jdbc;
import java.sql.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private DataSource myPool;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter salida =response.getWriter();
		response.setContentType("text/plain");
		
		//crear conexion 
		Connection myConexion=null;
		Statement myStatement=null;
		ResultSet myRs=null;
		
		try {
			
			myPool = (DataSource) new InitialContext().lookup("java:comp/env/" + "jdbc/db");
			
			
			 myConexion = myPool.getConnection();
			 
			 String  myString="SELECT nombre FROM productos";
			 
			 myStatement = myConexion.createStatement();
			 
			 myRs=myStatement.executeQuery(myString);
			 
			 while(myRs.next()) {
				 
				 String nombre=myRs.getString(1);
				 salida.println(nombre);
				 
				 
				 
				 
			 }
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
	}

}
