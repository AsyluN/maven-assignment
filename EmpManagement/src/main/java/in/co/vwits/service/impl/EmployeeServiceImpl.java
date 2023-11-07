
package in.co.vwits.service.impl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import in.co.vwits.emp.dao.impl.EmployeeJDBCDaoImpl;
import in.co.vwits.emp.model.Employee;
import in.co.vwits.model.exception.EmployeeNotFoundException;
import in.co.vwits.service.EmployeeService;
import in.co.vwits.sms.dao.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao dao;
	public EmployeeServiceImpl(){
		dao= new EmployeeJDBCDaoImpl();

	}	

	//Using Sorted
	@Override
	public List<Employee> findAllStudentSortedBySalary(){
		return dao.findAll().stream().sorted().collect(Collectors.toList()); 
	}

	@Override
	public List<Employee> findAll(){
		return dao.findAll();
	}
	@Override
	public void save(Employee s) {
		dao.save(s);
	}
	//Find Case 3
	public Optional<Employee> findByEmpId(int EmpId) throws EmployeeNotFoundException {
		Optional<Employee> p=dao.findByEmpId(EmpId);
		if(p.isPresent()) {
			return p;
		}
		else {
			// throw user defined exception "StudentNotFound"
			throw new EmployeeNotFoundException();
		}

	}
	@Override
	public void deleteByEmpId(int rollno) {
		dao.deleteByEmpId(rollno);

	}
	
	  @Override
	public void updateByEmpId(int rollno, double modifiedMarks) {
	  dao.updateByEmpId(rollno,modifiedMarks); }

}
