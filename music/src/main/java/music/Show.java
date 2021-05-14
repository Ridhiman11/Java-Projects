package music;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Show extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/music","root", "Ridhi@123");
			Statement smt=con.createStatement();
			String q = "SELECT * FROM cdtable";
			ResultSet rs = smt.executeQuery(q);
			while(rs.next()) {
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				int qty = rs.getInt("Quantity");
				int cost = rs.getInt("Cost");
				PrintWriter out = res.getWriter();
				out.println("<br>Id : "+id+" Name: "+name+" Quantity: "+qty+" Cost: "+cost);
				
			}
	}
		catch(Exception e){ System.out.println(e);}  	
	}
}
