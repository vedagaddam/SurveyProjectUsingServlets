
import java.io.*;  
import javax.servlet.*;    
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GatherData
 */
@WebServlet("/GatherData")
public class GatherData extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDAO sdao = new StudentDAO();
		String gmuid=request.getParameter("id");
		System.out.println(gmuid);		
		StudentBean sb=sdao.retrieveFormFromDB(gmuid);
		
		HttpSession session = request.getSession();
		session.setAttribute("student", sb);
		String address;
		if (sb != null)	{  
			address = "Student.jsp";
		}
		else{
			address= "NoStudent.jsp";
		}		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=\"UTF-8\"");
		//Session creation
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		//out.print("<html> <body> Welcome Page");
		StudentDAO sdao = new StudentDAO();
		//Calling the StudentDAO object to save data in the database by sending the request as a parameter
		sdao.saveFormToDB(request);
		//creating Data bean to store mean and average
		DataBean dBean = new DataBean(); 
		DataProcessor dataP = new DataProcessor();
		String numData = request.getParameter("numdata");
		//Calculating mean by calling the computeMean of data processor
		double mean = dataP.computeMean(numData);
		//Storing the mean in the data bean
		dBean.setMean(mean);
		System.out.println("MEAN");
		//Calculating SD by calling the computeSD of data processor and storing it in the data bean
		dBean.setStadardDeviation(dataP.computeSD(numData, dBean.getMean()));
		System.out.println("SD");
		//Storing the data bean in the session
		session.setAttribute("dBean", dBean);
		//Database connection
		String idString = "";
		try{
	    	   Class.forName("oracle.jdbc.driver.OracleDriver");
	    } 
		catch (ClassNotFoundException ex) {
	    	   	System.out.println(ex);
	     }
		 try {
			 //DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver());
	     	 Connection con;
	         con = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g", "vgaddam", "ptuphy");
	         System.out.println("Connection established");
	         Statement stmt= con.createStatement();
	         ResultSet rs= stmt.executeQuery("select gmuid from studentdata");
	         while (rs.next())
	         {
	        	 idString += rs.getString(1) + " ";
	        	 System.out.println(idString);
	         }
	         String[] ids = idString.split(" ");
	         for(int l = 0; l < ids.length; l++){
	        	 System.out.println("id "+ l + " num "+ ids[l]);
	         }
	         request.setAttribute("ids", ids);
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
		
		System.out.println("cehcking mean");
		if(mean > 90){
			System.out.println("greater 90 mean");
			String urlname = "WinnerAcknowledgement.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(urlname);
			System.out.println("dispatch");
			dispatcher.forward(request, response);
		}
		else{
			System.out.println("less 90 mean");
			String urlname = "SimpleAcknowledgement.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(urlname);
			System.out.println("dispatch");
			dispatcher.forward(request, response);
		}
		
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
