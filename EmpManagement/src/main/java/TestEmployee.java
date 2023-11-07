import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import in.co.vwits.emp.model.Employee;
import in.co.vwits.model.exception.EmployeeNotFoundException;
import in.co.vwits.service.EmployeeService;
import in.co.vwits.service.impl.EmployeeServiceImpl;

public class TestEmployee {

	public static void main(String[] args) {
		int option=1;
		Scanner sc = null;
		try {
			sc=new Scanner(System.in);
			EmployeeService service = new EmployeeServiceImpl();
		
	do {
			System.out.println("Welcome to employee mangement ");
			System.out.println("1 Find all records");
			System.out.println("2 Insert Records");
			System.out.println("3 Find Employee by Employee ID");
			System.out.println("4 Delete student by Employee ID");
			System.out.println("5 Update student by Employee ID");
			System.out.println("6 Sort in asc order");
			System.out.println("-1 to Exit");
			System.out.println("Enter choice");
			
			option= sc.nextInt();
			
			switch(option) {
			case 1:
				List<Employee> employees = service.findAll();
			    System.out.println(employees);
			    break;
			case 2:
				//
				Employee s= new Employee();
				s.setName("Ram");
				s.setempid(23);
				s.setsalary(98);
				service.save(s);
				break;
			case 3:
				System.out.println("Enter the Employee ID");
				int empid=sc.nextInt();
				Optional<Employee> foundemployee;
				
				try {
					
					foundemployee = service.findByEmpId(empid);
					System.out.println("Found Student"+foundemployee.get());
				} catch (EmployeeNotFoundException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("Employee Not Found");
				}
				
				break;
			case 4:
				System.out.println("Enter the Employee ID");
				try {
					empid=sc.nextInt();
					service.deleteByEmpId(empid);
				}
				catch(InputMismatchException e) {
					System.out.println("Emp Id must be an Integer value");
					sc.nextLine(); 
				}
			
				break;
			
			case 5:
				double modifiedSalary;
				System.out.println("Enter the Employee ID");
				empid=sc.nextInt();
				System.out.println("Enter new salary");
				modifiedSalary=sc.nextDouble();
				service.updateByEmpId(empid,modifiedSalary);
				break;
				
			case 6:
				System.out.println(service.findAllStudentSortedBySalary());
				break;
		
			case -1:
				System.out.println("--------------------Thank You---------------------");
				break;
				
			}
			
		}while(option!=-1);
		}
		finally {
			sc.close();
		}
		
		
		
		


	}

}
