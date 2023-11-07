package in.co.vwits.emp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import in.co.vwits.emp.model.Employee;
import in.co.vwits.sms.dao.EmployeeDao;

public class EmployeeJDBCDaoImpl implements EmployeeDao{
	//Save 
	public int save(Employee s) { 
		try (Connection con =
			DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root",
					"root");
		PreparedStatement pstmt =con.prepareStatement("INSERT INTO tbl_emp VALUES(?,?,?)");) {
		pstmt.setInt(1, s.getempid()); 
		pstmt.setString(2,s.getName());
		pstmt.setDouble(3,s.getsalary());
		
	int noOfRowSpaceUpdated = pstmt.executeUpdate();// firing query...
		

		return noOfRowSpaceUpdated;
		}
	catch (SQLException e) { e.printStackTrace(); }
     return 0;
	}
	
	//Delete
	public void deleteByEmpId(int empid) {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","root");
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM tbl_emp WHERE empid = ?"); 
				){
			pstmt.setInt(1, empid);
			int noOfRowsUpdated = pstmt.executeUpdate(); // firing query
			System.out.println("No of records affected are: "+ noOfRowsUpdated);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Update
	public void updateByEmpId(int empid, double modifiedsalary) {
		try 
		(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","root");
		 PreparedStatement pstmt = con.prepareStatement("UPDATE tbl_emp SET salary =? WHERE empid =?");)
		 {
	    pstmt.setDouble(1,modifiedsalary);
        pstmt.setInt(2,empid);
      
              
        int noOfRowSpaceUpdated = pstmt.executeUpdate();// firing query...

        System.out.println("No of records updated are "+ noOfRowSpaceUpdated);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
	
	
	//Find by empid
	
	public Optional<Employee> findByEmpId(int rollno)
	{
		try 
		(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","root");
	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbl_emp WHERE empid= ?");)
		
		{Employee foundEmployee = new Employee();
         pstmt.setInt(1, rollno);
       
        ResultSet rs = pstmt.executeQuery();//firing query- 
        if(rs.next()) {                          //this method returns true if any 
                                                 //records are present
        	foundEmployee.setempid(rs.getInt(1));
        	foundEmployee.setName(rs.getString(2));
        	foundEmployee.setsalary(rs.getDouble(3));    	
        }
        return Optional.of(foundEmployee);
       
	} catch (SQLException e) {
		e.printStackTrace();
	}
	/*
	 * finally { try { pstmt.close(); con.close(); }catch(SQL Exception e) {
	 * e.printStackTrace(); } }
	 */
		return Optional.empty();
		
	}
	//Find All
	public List<Employee> findAll(){
		List<Employee> employees= new ArrayList<>();
		try 
		(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","root");
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM tbl_emp ");)
		{
			
			ResultSet rs = pstmt.executeQuery();//firing query- 
			while(rs.next()) {                          //this method returns true if any 
				//records are present
				Employee foundEmployee=new Employee();
				foundEmployee.setempid(rs.getInt(1));
	        	foundEmployee.setName(rs.getString(2));
	        	foundEmployee.setsalary(rs.getDouble(3));
				employees.add(foundEmployee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
		 
		
}


	


