package in.co.vwits.sms.dao;

import java.util.List;
import java.util.Optional;

import in.co.vwits.emp.model.Employee;

public interface EmployeeDao {
	public int save(Employee s);
	public Optional<Employee> findByEmpId(int rollno);
	public List<Employee> findAll();
	public void deleteByEmpId(int rollno);
	  public void updateByEmpId(int rollno, double modifiedMarks);

}
