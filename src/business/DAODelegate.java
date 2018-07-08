package business;

import hibernate.Allocation;
import hibernate.Department;
import hibernate.Employees;
import hibernate.Expenditure;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import session.SessionCRUDRemote;

public class DAODelegate implements IDAODelegate {
	
		
		@Override
		public SessionCRUDRemote lookupJNDI() {
			SessionCRUDRemote src = null;
			try {
				Properties env = new Properties();
				env.put(Context.INITIAL_CONTEXT_FACTORY,
						"weblogic.jndi.WLInitialContextFactory");
				env.put(Context.PROVIDER_URL, "t3://localhost:7001");
				Context ic = new InitialContext(env);
				src = (SessionCRUDRemote) ic.lookup("ejb/BudgetCon");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			return src;
		}
		
		
		@Override
		public void insertEmployees(Employees employee, Department department) {
			SessionCRUDRemote src = lookupJNDI();
			src.addEmployees(employee, department);
		}
		
		
		@Override
		public List<Employees> checkEmployees() {
			SessionCRUDRemote src = lookupJNDI();
			return src.checkEmployees();
		}
		
		@Override
		public void insertAllocation(Allocation allocation,
				Department department) {
			SessionCRUDRemote src = lookupJNDI();	
			src.submitAllocation(allocation, department);
		}
		
		
		@Override
		public void insertExpend(Expenditure expenditure, Department department) {
			SessionCRUDRemote src = lookupJNDI();
			src.insertExpense(expenditure, department);
		}
		
		
		@Override
		public Department retrieveDepartment(String department) {
			SessionCRUDRemote src = lookupJNDI();
			return src.getDepartmentID(department);
		}
		
		
		
		@Override
		public List<Expenditure> retrieveFin(String startDate, String endDate,
				Long deptID) {
			SessionCRUDRemote src = lookupJNDI();
			return src.retrieveFin(startDate, endDate, deptID);
		}
		
		
		@Override
		public void updateAllocation(String expendType, Double amount,
				Long deptID) {
			SessionCRUDRemote src = lookupJNDI();
			src.updateAllocation(expendType, amount, deptID);
		}
		
		@Override
		public List<Allocation> retrieveAll(Long deptID){
			SessionCRUDRemote src = lookupJNDI();
			return src.retrieveAll(deptID);
		}
		
		@Override
		public Map<Long, String> retrieveDeptNames(){
			SessionCRUDRemote src = lookupJNDI();
			return src.retrieveDeptNames();
		}
		
	}

