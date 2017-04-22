import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class StudentDAO {

		public void saveFormToDB(HttpServletRequest request) throws ServletException, IOException{
			  
			 String studentName = request.getParameter("uname");
			 String gmuId = request.getParameter("gmuid");
			 String streetAddress = request.getParameter("address");
			 String city = request.getParameter("city");
			 String state = request.getParameter("state");
			 String zip = request.getParameter("zip");
			 String telephone = request.getParameter("phone");
			 String email = request.getParameter("emailid");
			 String url = request.getParameter("url");
			 String dateOfSurvey = request.getParameter("date");
			 String[] likes = request.getParameterValues("like");
			 String interested = request.getParameter("univ");
			 String graduationMonth = request.getParameter("months");
			 String graduationYear = request.getParameter("year");
			 String additionalComments = request.getParameter("acomment");
			 String likelyhood = request.getParameter("recommend");
			 
			 
			 String likesStr = "";
			 for(int i = 0; i < likes.length; i++){
				 if(i == likes.length -1){
					 likesStr += likes[i];
				 }
				 else
					 likesStr += likes[i] + ",";
			 }
			
			 try
		       {
		    	   Class.forName("oracle.jdbc.driver.OracleDriver");
	    } catch (ClassNotFoundException ex) {
	        System.out.println(ex);
	    }

			 try {
				 //DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver());
	        	 Connection con;
	            con = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g", "DATABASE_USERNAME", "PASSWORD");
	            System.out.println("Connection established");
	            Statement stmt= con.createStatement();
	           // stmt.executeUpdate("Drop table studentdata");
	            //stmt.executeUpdate("CREATE TABLE STUDENTDATA(studentName varchar2(30), gmuId varchar2(11),streetAddress varchar2(45),city varchar2(15), state varchar2(15), zip varchar2(6), telephone varchar2(18),email varchar2(30),url varchar2(30),dateOfSurvey varchar2(18),likes varchar2(45),interested varchar2(30),graduationMonth varchar2(12),graduationYear varchar2(5),additionalComments varchar2(30))");
			 	//ResultSet result = stmt.executeQuery("select * from STUDENTDATA");
	            String insertSql = "insert into studentdata values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	            PreparedStatement pstmt= con.prepareStatement(insertSql);
	           
	            pstmt.setString(1, studentName);
	            pstmt.setString(2, gmuId);
	            pstmt.setString(3, streetAddress);
	            pstmt.setString(4, city);
	            pstmt.setString(5, state);
	            pstmt.setString(6, zip);
	            pstmt.setString(7, telephone);
	            pstmt.setString(8, email);
	            pstmt.setString(9, url);
	            pstmt.setString(10, dateOfSurvey);
	            pstmt.setString(11, likesStr);
	            pstmt.setString(12, interested);
	            pstmt.setString(13, graduationMonth);
	            pstmt.setString(14, graduationYear);
	            pstmt.setString(15, additionalComments);
	            pstmt.setString(16, likelyhood);
	            pstmt.executeUpdate();
	            System.out.println("statement executed");
			 }
			 catch (SQLException ex) {
		            System.out.println(ex);
		        }


		}

		
		
		 public StudentBean retrieveFormFromDB(String id) {
		        StudentBean sb = new StudentBean();
		 System.out.println("inside retireve");
		        try {
		            Class.forName("oracle.jdbc.driver.OracleDriver");
		            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g", "DATABASE_USERNAME", "PASSWORD");
		            Statement stmt = con.createStatement();
		            System.out.println("connection established");
		            System.out.println(id);
		            id="'"+id+"'";
		            ResultSet result = stmt.executeQuery("Select * from studentdata where gmuid =" + id);
		            
		            while (result.next()) {
		            	System.out.println("result set");
		            	 sb.setStudentName(result.getString(1));
		    			 sb.setGmuId(result.getString(2));
		    			 sb.setStreetAddress(result.getString(3));
		    			 sb.setCity(result.getString(4));
		    			 sb.setState(result.getString(5));
		    			 sb.setZip(result.getString(6));
		    			 sb.setTelephone(result.getString(7));
		    			 sb.setEmail(result.getString(8));
		    			 sb.setUrl(result.getString(9));
		    			 sb.setDateOfSurvey(result.getString(10));
		    			 sb.setLikes(result.getString(11));
		    			 sb.setInterested(result.getString(12));
		    			 sb.setGraduationMonth(result.getString(13));
		    			 sb.setGraduationYear(result.getString(14));
		    			 sb.setAdditionalComments(result.getString(15));
		    			 sb.setLikelyhood(result.getString(16));
		    			 System.out.println(sb.getStudentName() +"  "+ sb.getGmuId() +"  "+ sb.getStreetAddress() +"  "+ 
		    			 sb.getCity() +"  "+ sb.getState() +"  "+ sb.getZip() +"  "+ sb.getTelephone() +"  "+ 
		    		     sb.getEmail() +"  "+ sb.getUrl() +"  "+ sb.getDateOfSurvey() +"  "+ sb.getLikes() +"  "+ 
		    			 sb.getInterested() +"  "+ sb.getGraduationMonth()  +"  "+ sb.getGraduationYear() +"  "+ 
		    		     sb.getAdditionalComments() +"  "+ sb.getLikelyhood());
		               
		                	                
		                
		                System.out.println("fininshed retirieve");


		            }
		            System.out.println("exit");
		            con.close();
		           
		        } catch (Exception e) {
		        }
		        
	       return sb; 
		    }


		
	
}
