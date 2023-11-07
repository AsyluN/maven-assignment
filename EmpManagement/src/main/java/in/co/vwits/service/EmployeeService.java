package in.co.vwits.service;

import java.util.List;
import java.util.Optional;

import in.co.vwits.emp.model.Employee;
import in.co.vwits.model.exception.EmployeeNotFoundException;

public interface EmployeeService {


	//Using Sorted
	List<Employee> findAllStudentSortedBySalary();

	List<Employee> findAll();

	void save(Employee s);

	//Find Case 3
	Optional<Employee> findByEmpId(int empid) throws EmployeeNotFoundException;


	void deleteByEmpId(int empid);

	void updateByEmpId(int empid, double modifiedSalary);

}