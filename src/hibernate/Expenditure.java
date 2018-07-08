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
public class Expenditure implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long expID;
	@Column
	private String expenseType;
	private String expenseDate;

	public String getExpenseDate() {
		return expenseDate;
	}

	public Department getDepartmentJoinTwo() {
		return departmentJoinTwo;
	}

	public void setDepartmentJoinTwo(Department departmentJoinTwo) {
		this.departmentJoinTwo = departmentJoinTwo;
	}

	public void setExpenseDate(String expenseDate) {
		this.expenseDate = expenseDate;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "deptID")
	private Department departmentJoinTwo;

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	private double expense;

	public long getExpID() {
		return expID;
	}

	public void setExpID(long expID) {
		this.expID = expID;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	@Override
	public String toString() {
		return "Expenditure [expID=" + expID + ", expenseType=" + expenseType
				+ ", expenseDate=" + expenseDate + ", departmentJoinTwo="
				+ departmentJoinTwo + ", expense=" + expense + "]";
	}

}
