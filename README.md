# Employee-Management-System
import java.util.*;

public class Employee
{
  String name;
	double salary, enteredDoub;
	int enteredNum;
	Scanner console = new Scanner(System.in);

	
	Employee(String n, double s)
	{
		name = n;
		salary = s;
		System.out.printf("\nThe Employee's name is %s and their salary is Rs%.2f a year.\n\n",name, salary);
	}

	
	Employee()
	{}


	void salary_change(double amount)
	{
		
		salary = getSalary();
		salary += amount;

		System.out.printf("%s's salary has been changed to Rs%.2f.", this.getEmployeeName(), this.getSalary());
	}
	
	void quit(ArrayList<Employee> emp)
	{
		int empNum;
		System.out.print("Enter Employee # whos salary do you want to set to Rs00.00: ");
		empNum = checkInt();

		if (empNum > emp.size())
		{
			System.out.println("Not a Valid Employee ID! Press 3 for Employee List.");
		}
		else
		{
			empNum -= 1;
			
			double amount = -emp.get(empNum).getSalary();
			emp.get(empNum).salary_change(amount);
		}				
	}
	
	void get_info(ArrayList<Employee> emp)
	{
		
		int j=0;
		System.out.println("All the employee information is:");
		for(Employee employee: emp)
		{
			System.out.println("#"+ (j + 1) + ": " + employee);
			j++;
		}
	}

	void change_status()
	{
		getEmployeeName();
		System.out.printf("Cannot change %s's status because they are a normal Employee.\n", name);
	}

	
	double getSalary()
	{
		return salary;
	}

	
	String getEmployeeName()
	{
		return name;
	}


	
	public String toString() 
	{
        return ("Employee's Name: "+this.getEmployeeName()+ "    Salary: Rs"+ this.getSalary());
    }

    void create_new(ArrayList<Employee> emp)
    {
    	int empNum, rank, category, emptype;
    	double sa;
    	String na;
    	
		System.out.print("How many Employee's would you like to create?:");
		empNum = checkInt();
    	
		for(int i = 0; i < empNum; i++)
		{
			System.out.println("\nWhat type of Employee would you like to create?");
			System.out.print("Enter 1 for Employee, 2 for Faculty, 3 for Staff: ");

			emptype = checkIntRange();

			switch(emptype)
			{
				case 1:
				{
					System.out.printf("What is Employee Name?: ");
					na = console.next();
					System.out.printf("\nWhat is %s's Salary?: ", na);
					sa = checkDouble();
					emp.add(new Employee(na,sa));
					break;	
				}

				case 2:
				{
					System.out.printf("What is the Faculty Member's Name?: ");
					na = console.next();
					System.out.printf("\nWhat is %s's Salary?: ", na);
					sa = checkDouble();

					System.out.print("\nSelect Faculty member's rank: 1 for Assistant Professor, 2 for Associate Professor, 3 for Professor: ");
					rank = checkIntRange();
					emp.add(new Faculty(na,sa,rank));
					break;
				}

				case 3:
				{
					System.out.printf("What is the Staff Member's Name?: ");
					na = console.next();
					System.out.printf("\nWhat is %s's Salary?: ", na);
					sa = checkDouble();

					System.out.print("\nSelect Staff Category: 1 for full-time or 2 for part-time: ");
					category = checkIntRange2();
					emp.add(new Staff(na,sa,category));
					break;
				}				
			}			
		}
    }

     

	public int checkInt()
	{
		do {
			while(!console.hasNextInt())
			{
				System.out.println("That is not a number!");
				console.next();
			}
			enteredNum = console.nextInt();
		}while (enteredNum <= 0);

		return enteredNum;
	}

	public int checkIntRange()
	{
		do {
			while(!console.hasNextInt())
			{
				System.out.println("That is not a number!");
				console.next();
			}
			enteredNum = console.nextInt();
		}while (enteredNum < 1 || enteredNum > 3);

		return enteredNum;
	}

	public int checkIntRange2()
	{
		do {
			while(!console.hasNextInt())
			{
				System.out.println("That is not a number!");
				console.next();
			}
			enteredNum = console.nextInt();
		}while (enteredNum < 1 || enteredNum > 2);

		return enteredNum;
	}

	public double checkDouble()
	{
		do {
			while(!console.hasNextDouble())
			{
				System.out.println("That is not a number!");
				console.next();
			}
			 enteredDoub = console.nextDouble();
		}while (enteredDoub <= 0);

		return enteredDoub;
	}   
}
