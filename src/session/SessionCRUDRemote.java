package session;

import java.util.List;
import java.util.Map;

import hibernate.Allocation;
import hibernate.Department;
import hibernate.Employees;
import hibernate.Expenditure;

import javax.ejb.Remote;

@Remote
public interface SessionCRUDRemote {

	// 1. Allocation
	
	// Method to insert allocation to database
	public void submitAllocation(Allocation allocation, Department department);

	// Update Allocation
	public void updateAllocation(String expenseType, Double expense, Long deptID);


	// Retrieve Allocation
	public List<Allocation> retrieveAll(Long deptID);
	
	// 2. Department
	
	// Get department names
	public Map<Long, String> retrieveDeptNames();

	// Retrieve departmentID for department name choosen
	public Department getDepartmentID(String department);

	// 3. Employees

	// Add registered employees
	public void addEmployees(Employees employee, Department department);

	// Retrieve users to check login credentials
	public List<Employees> checkEmployees();

	// 4. Expenditure

	public void insertExpense(Expenditure expenditure, Department department);

	public List<Expenditure> retrieveFin(String startDate, String endDate,
			Long deptID);

}
