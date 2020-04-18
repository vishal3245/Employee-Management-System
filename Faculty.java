import java.util.*;

public class Faculty extends Employee
{
  String name;
	double salary;
	String rank;

	Faculty(String n, double s, int r)
	{
		name = n;
		salary = s;

		switch(r)
		{
			case 1:
			{
				rank = "Assistant Professor";
				break;
			}

			case 2:
			{
				rank = "Associate Professor";
				break;
			}

			case 3:
			{
				rank = "Professor";
				break;
			}
		}

		System.out.printf("\n%s is a Faculty member that is a %s and makes Rs%.2f a year \n\n", name, rank, salary);
	}
	Faculty()
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

	
	void change_status()
	{
		
		System.out.printf("%s's is a currently a %s. What would you like to change their rank to?\n", name, rank);
		System.out.print("\nSelect Faculty member's rank: 1 for Assistant Professor, 2 for Associate Professor, 3 for Professor: ");
		int r = checkIntRange();
		
		switch(r)
		{
			case 1:
			{
				rank = "Assistant Professor";
				break;
			}

			case 2:
			{
				rank = "Associate Professor";
				break;
			}

			case 3:
			{
				rank = "Professor";
				break;
			}
		}
		System.out.printf("\n%s is now a %s", name, rank);
		
	}

	
	double getSalary()
	{
		return salary;
	}

	
	String getEmployeeName()
	{
		return name;
	}

	String getRank()
	{
		return rank;
	}

	
	public String toString() 
	{
        return ("Faculty Member's Name: "+ getEmployeeName()+ "    Salary: Rs"+ getSalary() + "    Rank: " + this.getRank());
    }

}
