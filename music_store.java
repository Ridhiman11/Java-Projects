import java.sql.*;
import java.util.Scanner;
public class music_store {

	public static void main(String[] args) {
		String uname = "root";
		String pass = "Ridhi@123";
		
	
		Scanner sc = new Scanner(System.in);
		int choice =0;
		while(choice!=4) {
		System.out.println("----Menu-----");
		System.out.println("1. Enter Inventory");
		System.out.println("2. Display Inventory");
		System.out.println("3. Buy CD ");
		System.out.println("4. Exit");
		 choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/music",uname,pass);
				Statement smt=con.createStatement();
				System.out.println("Enter Id");
				int id = sc.nextInt();
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter quantity");
				int qty = sc.nextInt();
				System.out.println("Enter cost");
				int cost = sc.nextInt();
				
				String q = "INSERT INTO cdtable VALUES("+"\""+ id+ "\"" + "," +"\""+name+"\""+","+"\""+qty+"\""+',' +"\""+cost+"\""+ ")";
				smt.executeUpdate(q);
				con.close();
				
		}
			catch(Exception e){ System.out.println(e);}  
		break;
		case 2:
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/music",uname, pass);
				Statement smt=con.createStatement();
				String q = "SELECT * FROM cdtable";
				ResultSet rs = smt.executeQuery(q);
				while(rs.next()) {
					int id = rs.getInt("Id");
					String name = rs.getString("Name");
					int qty = rs.getInt("Quantity");
					int cost = rs.getInt("Cost");
					
					System.out.println("Id : "+id+" Name: "+name+" Quantity: "+qty+" Cost: "+cost);
					
				}
		}
			catch(Exception e){ System.out.println(e);}  
		break;	
		case 3:
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/music",uname, pass);
				Statement smt=con.createStatement();
				System.out.println("Enter the id of cd ");
				int id = sc.nextInt();
				String q = "UPDATE cdtable SET Quantity = Quantity -1 WHERE Id ="+"\""+id+"\"";
				smt.execute(q);
				System.out.println("Thanks for purchasing");
		}
			catch(Exception e){ System.out.println(e);}  
		break;	
		case 4:
			
			System.out.println("exit");
		break;
		default:
			System.out.println("Please enter correct choice");
			break;
		}
		}
}
}
