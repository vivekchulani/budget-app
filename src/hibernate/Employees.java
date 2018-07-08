package hibernate;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="BudgetConUsers")
public class Employees implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long eid;

	@Column
	private String username;
	private String password;
	private String email;
	private long employeeID;	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="deptID")
	private Department departmentJoinThree;

	public long getId() {
		return eid;
	}



	public Department getDepartmentJoinThree() {
		return departmentJoinThree;
	}



	public void setDepartmentJoinThree(Department departmentJoinThree) {
		this.departmentJoinThree = departmentJoinThree;
	}



	public void setId(long eid) {
		this.eid = eid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}


	@Override
	public String toString() {
		return "Employees [eid=" + eid + ", username=" + username
				+ ", password=" + password + ", email=" + email
				+ ", employeeID=" + employeeID + ", departmentJoinThree="
				+ departmentJoinThree + "]";
	}
	
	

}
