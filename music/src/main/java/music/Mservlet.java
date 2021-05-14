package music;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Mservlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int id  = Integer.parseInt(req.getParameter("id"));
    	String name = req.getParameter("name");
    	int qty  = Integer.parseInt(req.getParameter("qty"));
    	int cost  = Integer.parseInt(req.getParameter("cost"));
    	PrintWriter out = res.getWriter();
    	
    	
    	String uname = "root";
		String pass = "Ridhi@123";
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/music",uname,pass);
			Statement smt=con.createStatement();
			String q = "INSERT INTO cdtable VALUES("+"\""+ id+ "\"" + "," +"\""+name+"\""+","+"\""+qty+"\""+',' +"\""+cost+"\""+ ")";
			smt.executeUpdate(q);
			con.close();
			out.println("<h1>Added Successfully</h1>");
	}
		catch(Exception e){ System.out.println(e);}  
	}
}
