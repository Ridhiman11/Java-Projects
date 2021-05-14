package stud;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class S_Servlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String uid = req.getParameter("uid");
		String name = req.getParameter("name");
		String sub_name = req.getParameter("sub_name");
		String sub_code = req.getParameter("sub_code");
		int marks = Integer.parseInt(req.getParameter("marks"));
		int max_marks = Integer.parseInt(req.getParameter("max_marks"));
		
		String uname = "root";
		String pass = "Ridhi@123";
		PrintWriter r = res.getWriter();
		r.println("<h3>Information Inserted </h3><br>");
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/student",uname,pass);
			Statement smt=con.createStatement();
			String q = "INSERT INTO marks VALUES("
					+"\""+ uid+ "\"" + "," +"\""+name+"\""+","+"\""+sub_name+"\""+',' +"\""+sub_code+"\""+","+"\""+marks+"\"" +","+"\""+max_marks+"\""+ ")";
			smt.executeUpdate(q);
			String qt = "SELECT * FROM marks WHERE Marks>80";
			ResultSet rs = smt.executeQuery(qt);
			r.println("Students who got mor than 80: <br>");
			while(rs.next()) {
				r.println();
				String uid1 = rs.getString("UID");
				String name1 = rs.getString("Name");
				r.println("<table style='border: 1px solid black;' >"
						+ "<tr>"
						+ "<td>"
						+ uid1
						+ "</td>"
						+ "<td>"
						+ name1
						+ "</td>"
						+ "</tr>"
						+ "<table>");
				
				
			}
			con.close();
			
	}
		catch(Exception e){ System.out.println(e);}  
		
	}
	}

