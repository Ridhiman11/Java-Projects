import java.io.*;
import java.text.Format;
import java.util.ArrayList;
import java.util.Scanner;
class Employee implements java.io.Serializable{
	String name;
	 int id;
	 int salary;
	 String desg;
	 public Employee() {
		 
	 }
//	public Employee(String name, int id, int salary, String desg) {
//		this.name = name;
//		this.id = id;
//		this.salary = salary;
//		this.desg = desg;
//	}
	public void setEmpName(String name) {
		this.name = name;
	}
	public void setEmpId(int id) {
		this.id = id;
	}
	public void setEmpSal(int salary) {
		this.salary = salary;
	}
	public void setEmpDesg(String desg) {
		this.desg = desg;
	}
	public String getEmpName() {
		return name;
	}
	public int getEmpId() {
			return id;
		}
	public int getEmpSal() {
			return salary;
		}
	public String getEmpDesg() {
		return desg;
	}
	@Override
	public String toString() {
		return "name ="+this.getEmpName() +"id = " + this.getEmpId() + ";salary = " + this.getEmpSal() + ";designation = " + this.getEmpDesg();
		
		
	}
//	public static void display(ArrayList<Employee> a) {
//		System.out.println("hi");
//		for(Employee e : a ) {
//			System.out.println("Hello");
//			System.out.printf("name = %s, id = %d, salary = %d, designation = %s",e.name,e.id,e.salary,e.desg);
//		}
//	}
	
	
	 
}
public class Emp {

	
	public static void main(String[] args) {
		ArrayList<Employee> a = new ArrayList<Employee>();
			do {
			System.out.println("\n1. Add an Employee");
			System.out.println("2. Display All");
			System.out.println("3. Add to file");
			System.out.println("4. Read from file");
			System.out.println("5. Exit");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			
			Employee m = new Employee();
			
			switch(choice) {
			case 1:
				System.out.println("Enter Employee's Name: ");
				String name = input.next();
				m.setEmpName(name);
				System.out.println("Enter Employee's id: ");
				int id = input.nextInt();
				m.setEmpId(id);
				System.out.println("Enter salary: ");
				int salary = input.nextInt();
				m.setEmpSal(salary);
				System.out.println("Enter designation");
				String desg = input.next();
				m.setEmpDesg(desg);
				a.add(m);
				System.out.println("Employee Adeed Successfully");
				break;
			case 2 :
				for(Employee emp :a) {
					System.out.println(emp);
				}
				break;
			case 3:
				
				System.out.println("Enter file name");
				String fname = input.next();
				try {
					FileOutputStream f = new FileOutputStream(fname);
					ObjectOutputStream o = new ObjectOutputStream(f);
					o.writeObject(a);
//					o.close();
					System.out.println("Employee added successfully");
					
				}
				catch(Exception e){
					System.out.println(e);
				}
				break;
			case 4:
				System.out.println("Enter the file name : ");
				String f1name = input.next();
				 
				
				try {
					FileInputStream f1 = new FileInputStream(f1name);
					ObjectInputStream o1 = new ObjectInputStream(f1);
					ArrayList<Employee> e2 = (ArrayList<Employee>)o1.readObject();
					for(Employee e : e2 ) {
						System.out.println(e);
					}
					
					o1.close();
					} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Thank You");
				break;
			default:
				System.out.println("Please enter correct choice");
			}
			
	}
	while(true);
		
	

	
}
}
