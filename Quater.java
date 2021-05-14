package r;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
class Sales implements java.io.Serializable {
	String q_id;
	int year;
	int vlm;
	public String getQ_id() {
		return q_id;
	}
	public void setQ_id(String q_id) {
		this.q_id = q_id;
	}
	@Override
	public String toString() {
		return "Sales [q_id=" + q_id + ", year=" + year + ", vlm=" + vlm + "]";
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getVlm() {
		return vlm;
	}
	public void setVlm(int vlm) {
		this.vlm = vlm;
	}
}
public class Quater {
	public static void main() {
		do {
		System.out.println("\n1. Enter Sales Volume");
		System.out.println("2. Display Entered Information ");
		System.out.println("3. Serialize the Details ");
		System.out.println("4. Deserialize and Display Non-performing quarters");
		System.out.println("5. Exit");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		ArrayList<Sales> a = new ArrayList<Sales>();
		Sales s = new Sales();
		switch(choice) {
		case 1:
			System.out.println("Enter QuaterID: ");
			String q_id =input.next();
			s.setQ_id(q_id);
			System.out.println("Enter Year: ");
			int year = input.nextInt();
			s.setYear(year);
			System.out.println("Enter sales volume: ");
			int vlm = input.nextInt();
			s.setVlm(vlm);
			
			a.add(s);
		break;
		case 2:
			for(Sales s1: a) {
				System.out.println(s1);
			}
		break;
		case 3:
			
			String fname = "sales_info.ser";
			try {
				FileOutputStream f = new FileOutputStream(fname);
				ObjectOutputStream o = new ObjectOutputStream(f);
				o.writeObject(a);
//				o.close();
				System.out.println("Info added successfully");
				
			}
			catch(Exception e){
				System.out.println(e);
			}
			break;
		case 4:
			
			String f1name = "sales_info.ser";
			 
			
			try {
				FileInputStream f1 = new FileInputStream(f1name);
				ObjectInputStream o1 = new ObjectInputStream(f1);
				ArrayList<Sales> e2 = (ArrayList<Sales>)o1.readObject();
				for(Sales e : e2 ) {
					if(s.vlm<50000) {
					System.out.println(e);}
				}
				
				o1.close();
				} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("Please Enter correct choice");
		}
		}while(true);
}
}
