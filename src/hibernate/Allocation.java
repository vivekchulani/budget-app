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

@SuppressWarnings("serial")
@Entity
public class Allocation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long allID;
	@Column
	private double amount;
	private double amountDuplicate;
	
	public double getAmountDuplicate() {
		return amountDuplicate;
	}

	public void setAmountDuplicate(double amountDuplicate) {
		this.amountDuplicate = amountDuplicate;
	}

	private String allocationDate;

	public String getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(String allocationDate) {
		this.allocationDate = allocationDate;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "deptID")
	private Department departmentJoin;

	public Department getDepartmentJoin() {
		return departmentJoin;
	}

	public void setDepartmentJoin(Department departmentJoin) {
		this.departmentJoin = departmentJoin;
	}

	public long getAllID() {
		return allID;
	}

	public void setAllID(long allID) {
		this.allID = allID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Allocation [allID=" + allID + ", amount=" + amount
				+ ", amountDuplicate=" + amountDuplicate + ", allocationDate="
				+ allocationDate + ", departmentJoin=" + departmentJoin + "]";
	}

}
