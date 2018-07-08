package business;

import hibernate.Allocation;
import hibernate.Department;
import hibernate.Employees;
import hibernate.Expenditure;

import java.util.List;
import java.util.Map;

import session.SessionCRUDRemote;

public interface IDAODelegate {
	
	public SessionCRUDRemote lookupJNDI();
	
	// Insert new employees (registration)
	public void insertEmployees (Employees employee, Department department);
	
	// Retrieve employees to check credentials (login)
	public List<Employees> checkEmployees();
	
	// Insert budget allocation by admin (allocation)
	public void insertAllocation(Allocation allocation, Department department);
	
	// Insert expenditure submitted by user 
	public void insertExpend(Expenditure expenditure, Department department);
	
	// Retrieve department object to get departmentID
	public Department retrieveDepartment(String department);
	
	// Retrieve financial data 
	public List<Expenditure> retrieveFin(String startDate, String endDate, Long deptID);
	
	// Update allocation
	public void updateAllocation(String expendType, Double amount, Long deptID);
	
	
	//Retrieve Allocation
	public List<Allocation> retrieveAll(Long deptID);
	
	// Retrieve Department names 
	public Map<Long, String> retrieveDeptNames();
	
}
