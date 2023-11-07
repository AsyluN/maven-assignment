package in.co.vwits.emp.dao.impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import in.co.vwits.emp.model.Employee;

public class EmployeeDaoImpl {
	
	private List<Employee> employees;
	
	public EmployeeDaoImpl() {
		employees = new ArrayList<Employee>();
		Employee s1= new Employee();
		s1.setempid(1);
		s1.setName("Harsh");
		s1.setsalary(36879);
	
		Employee s2= new Employee();
		s2.setempid(2);
		s2.setName("Raj");
		s2.setsalary(34789);
	
		
		Employee s3= new Employee();
		s3.setempid(3);
		s3.setName("Rahul");
		s3.setsalary(32879);
		
		employees.add(s1);
		employees.add(s2);
		employees.add(s3);
	}
	public List<Employee> findAll(){
		return employees;
	}
	public void save(Employee s) {
		employees.add(s);
	}
	
	public Optional<Employee> findByEmpId(int EmpId) {
		for(Employee s:employees) {
			if(s.getempid()==EmpId) {
				return Optional.of(s);				
			}
		}
		return Optional.empty();
		
		
	}
	public void deleteByEmpId(int EmpId) {
		
		Iterator<Employee>i= employees.iterator();
		while(i.hasNext()) {
			Employee s= i.next();
			if(s.getempid()==EmpId) {
				i.remove();
			}
		}
		
	}
    public void updateByEmpId(int EmpId, double modifiedMarks) {
		for(Employee s:employees) {
			if(s.getempid()==EmpId) {
				s.setsalary(modifiedMarks);
			}
		}
		
	}
    
   

}