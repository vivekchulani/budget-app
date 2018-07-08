package hibernate;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Department implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long deptID;
	@Column
	private String department;
	@OneToMany(fetch=FetchType.EAGER, mappedBy="departmentJoinTwo")
	private Set<Expenditure> expenditure;
	@OneToMany(fetch=FetchType.EAGER, mappedBy="departmentJoin")
	private Set<Allocation> allocation;
	@OneToMany(fetch=FetchType.EAGER , mappedBy="departmentJoinThree")
	private Set<Employees> employees;
	
	public Set<Expenditure> getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(Set<Expenditure> expenditure) {
		this.expenditure = expenditure;
	}

	public Set<Allocation> getAllocation() {
		return allocation;
	}

	public void setAllocation(Set<Allocation> allocation) {
		this.allocation = allocation;
	}

	public Set<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employees> employees) {
		this.employees = employees;
	}

	public long getDeptID() {
		return deptID;
	}

	public void setDeptID(long deptID) {
		this.deptID = deptID;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Department [deptID=" + deptID + ", department=" + department
				+ "]";
	}

}
