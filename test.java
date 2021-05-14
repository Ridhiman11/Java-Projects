import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;

class Student{
	String uid;
	String name;
	int m1;
	int m2;
	
	public Student(String sid,String sname,int sm1,int sm2) {
		this.m1 = sm1;
		this.m2 = sm2;
		this.uid = sid;
		this.name = sname;	
	}
	public String getName() {
		return name;
	}
	public String getUid() {
		return uid;
	}
	public int getMarks1() {
		return m1;
	}
	public int getMarks2() {
		return m2;
	}
	public int getTotal() {
		return m1+m2;
	}
}

public class test{
	public static void main(String args[]) {
		List<Student> slist = new ArrayList<>();
		do {
		System.out.println("Main menu");
		System.out.println("1. Enter Student details");
		System.out.println("2. Display details");
		System.out.println("3. Search and print");
		System.out.println("4. Exit");
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		switch(ch) {
		case 1:
			System.out.println("Enter UID");
			String uid = sc.next();
			System.out.println("Enter name");
			String name = sc.next();
			System.out.println("Enter Marks");
			int m1 = sc.nextInt();
			System.out.println("Enter Marks");
			int m2 = sc.nextInt();
			Student st =  new Student(uid,name,m1,m2);
			slist.add(st);
			String fileName = "student.ser";
			try {
				FileOutputStream f = new FileOutputStream(fileName);
				ObjectOutputStream o =  new ObjectOutputStream(f);
				o.writeObject(slist);
			}
			catch(Exception e){
				//System.out.println(e);
			}
			break;
		case 2:
			for(Student s: slist) {
				System.out.println(s.getUid()+" " + s.getName()+" "+ s.getMarks1() +" " +s.getMarks2());
			}
			break;
		case 3:
			System.out.println("Enter UID");
			String search = sc.next();
			for(Student s1 : slist) {
				s1.getUid();
				if(search.equals(s1.getUid())) {
					System.out.println(s1.getUid()+" "+s1.getName()+" "+ s1.getTotal());
				}
				else {
					System.out.println("Uid not present");
				}
			}
//			if(slist.contains(search)) {
//				System.out.println("p");
//			}
			break;
		case 4:
			System.out.println("Thank You");
			System.exit(ch);
			break;
		default:
			System.out.println("Please enter correct choice");
		}
		}while(true);
	}
}