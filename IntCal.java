package r;

import java.util.Scanner;
abstract class Account {
    double interestRate;
    double amount; 
    abstract double calculateInterest(double amount) throws InvalidAge,InvalidMonths,InvalidDays,InvalidAmount;
}


public class IntCal {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
		
		System.out.println("Main Menu");
		System.out.println("---------");
		System.out.println("1. Interest Calculator - SB");
		System.out.println("2. Interest Calculator - RD");
		System.out.println("3. Interest Calculator - FD");
		System.out.println("4. Exit");
		System.out.println("Enter your option (1...4):");
		int opt = input.nextInt();
	
		switch(opt) {
		case 1:
			SBaccount sb = new SBaccount();
			System.out.println("Enter the average amount in your account");
			try {
			double sb_am = input.nextDouble();
			if(sb_am<0) {throw new InvalidAmount();}
			System.out.println("Interest gained is : Rs." + sb.calculateInterest(sb_am)+"\n");
			main(args);
			}
			catch(InvalidAmount e) {
				System.err.println("Enter valid amount");
			}
			break;
		case 2:
			RDaccount rb = new RDaccount();
			System.out.println("Enter the monthly amount for RD:");
			try {
			double rb_am = input.nextDouble();
			if(rb_am<0) {throw new InvalidAmount();}
			 System.out.println("Interest gained is : Rs."+ rb.calculateInterest(rb_am) + "\n" );
			 main(args);}
			catch(InvalidAmount e) {System.err.println("Invalid Amount Entered");}
			catch(InvalidMonths e) {System.err.println("Please enter between 6 to 12 ");}
			catch(InvalidAge e) {System.err.println("Please enter a valid age");}
			 break;
		case 3:
			FDaccount f = new FDaccount();
			System.out.println("Enter the amount for FD: ");
			double fd_am = input.nextDouble();
			try {
			if(fd_am<0) {throw new InvalidAmount();}
			System.out.println("Interest gained is : Rs."+ f.calculateInterest(fd_am) + "\n" );
			main(args);}
			catch(InvalidAmount e) {System.err.println("Please enter valid amount");}
			catch (InvalidAge e) {System.err.println("Please enter a positive number");}
			catch (InvalidDays e) {System.err.println("Please enter a positive number");
				
			}
			break;
		case 4:
			System.out.println("Thanks for Visiting");
			break;
		default :
			System.err.println("Please choose between 1 and 4");
		}
		input.close();
	}

}

class SBaccount extends Account{
	double amount,  interestRate;
	Scanner Sb = new Scanner(System.in);
	
	double calculateInterest(double amount) {
		System.out.println("Select account type: \n1. NRI \n2. Normal ");
		int choice =Sb.nextInt();
		switch(choice) {
		case 1:
			interestRate = 0.06;
			break;
		case 2:
			interestRate = 0.04;
			break;
		default:
			System.err.println("Please enter right choice");;
		}
		return amount*interestRate;
		
	}
			
}

class RDaccount extends Account{

	double interestRate;
	int noOfMonths;int age;
	Scanner rd = new Scanner(System.in);
	double calculateInterest(double amount) throws InvalidAge,InvalidMonths {
		System.out.println("Enter no. of months");
		noOfMonths = rd.nextInt();
		if(noOfMonths<6 || noOfMonths>21 || noOfMonths<0) {
			throw new InvalidMonths();
		}
		System.out.println("Enter your age: ");
		age = rd.nextInt();
		if(age<0) {
			throw new InvalidAge();
		}
		if(age>60) {
			if(noOfMonths>=6 && noOfMonths <9) {
				interestRate = 8.00;
			}
			if(noOfMonths>=9 && noOfMonths <12) {
				interestRate = 8.25;
			}
			if(noOfMonths>=12 && noOfMonths <15) {
				interestRate = 8.50;
			}
			if(noOfMonths>=15 && noOfMonths <18) {
				interestRate = 8.75;
			}
			if(noOfMonths>=18 && noOfMonths <21) {
				interestRate = 9.00;
			}
			if(noOfMonths==21 ) {
				interestRate = 9.25;
			}
		}
		else {
			if(noOfMonths>=6 && noOfMonths <9) {
				interestRate = 7.50;
			}
			if(noOfMonths>=9 && noOfMonths <12) {
				interestRate = 7.75;
			}
			if(noOfMonths>=12 && noOfMonths <15) {
				interestRate = 8.00;
			}
			if(noOfMonths>=15 && noOfMonths <18) {
				interestRate = 8.25;
			}
			if(noOfMonths>=18 && noOfMonths <21) {
				interestRate = 8.50;
			}
			if(noOfMonths==21 ) {
				interestRate = 8.75;
			}
		}
		return amount*noOfMonths*interestRate;
	}
	
}

class FDaccount extends Account{
	double interestRate, amount;
	int noOfDays, ageOfHolder;
	Scanner fd = new Scanner(System.in);
	double calculateInterest(double amount) throws InvalidAge,InvalidDays {
		System.out.println("Enter the no. of days for FD: ");
		noOfDays = fd.nextInt();
		if(noOfDays <0) {
			throw new InvalidDays();
		}
		System.out.println("Enter you age");
		ageOfHolder = fd.nextInt();
		if(ageOfHolder<0) {
			throw new InvalidAge();
		}
		if(amount<10000000) {
			if(ageOfHolder>60) {
				if(noOfDays>=7 && noOfDays <15) {
					interestRate = 5.00;
				}
				if(noOfDays>=15 && noOfDays <30) {
					interestRate = 5.25;
				}
				if(noOfDays>=30 && noOfDays <45) {
					interestRate = 6.00;
				}
				if(noOfDays>=45 && noOfDays <60) {
					interestRate = 7.50;
				}
				if(noOfDays>=60 && noOfDays <185) {
					interestRate = 8.00;
				}
				if(noOfDays>=185 && noOfDays <366 ) {
					interestRate = 8.50;
				}
			}
			else {
				
					if(noOfDays>=7 && noOfDays <15) {
						interestRate = 4.50;
					}
					if(noOfDays>=15 && noOfDays <30) {
						interestRate = 4.75;
					}
					if(noOfDays>=30 && noOfDays <45) {
						interestRate = 5.50;
					}
					if(noOfDays>=45 && noOfDays <60) {
						interestRate = 7;
					}
					if(noOfDays>=60 && noOfDays <185) {
						interestRate = 7.50;
					}
					if(noOfDays>=185 && noOfDays <366 ) {
						interestRate = 8.00;
					}
			
				
		}
			}
		else {
			
				if(noOfDays>=7 && noOfDays <15) {
					interestRate = 6.50;
				}
				if(noOfDays>=15 && noOfDays <30) {
					interestRate = 6.75;
				}
				if(noOfDays>=30 && noOfDays <45) {
					interestRate = 6.75;
				}
				if(noOfDays>=45 && noOfDays <60) {
					interestRate = 8;
				}
				if(noOfDays>=60 && noOfDays <185) {
					interestRate = 8.50;
				}
				if(noOfDays>=185 && noOfDays <366 ) {
					interestRate = 10.00;
				}
			
		
	}
		return amount*interestRate;
		
}
}

class InvalidDays extends Exception{
	
	
}
class InvalidMonths extends Exception{
	
}
class InvalidAge extends Exception{
	
}
class InvalidAmount extends Exception{
	
}



