package controllers;

import hibernate.Department;
import hibernate.Expenditure;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import business.IDAODelegate;

@Controller
public class UserController {
	
	private String logoff = "You have been signed out. Thank you!";
	
	@Autowired
	IDAODelegate idd;

	@Autowired
	Expenditure expenditure;
	
	@RequestMapping(value = "/UserSubmit", method = RequestMethod.POST)
	public String userSubmit(ModelMap modelMap, HttpServletRequest request) {

		String expenseType = request.getParameter("expense");
		String amount = request.getParameter("amount");
		String expenseDate = request.getParameter("expenseDate");
		Double expend = Double.valueOf(amount);
		System.out.println(expenseType);
		System.out.println(expend);
		System.out.println(expenseDate);
		
		HttpSession session = request.getSession();
		Department department =  (Department) session.getAttribute("deptID");
		System.out.println(department.getDeptID());
		
		modelMap.addAttribute("Ex", expenseType);
		modelMap.addAttribute("Expend", expend);
		modelMap.addAttribute("DateE", expenseDate);
		
		expenditure.setExpenseType(expenseType);
		expenditure.setExpense(expend);
		expenditure.setExpenseDate(expenseDate);
		expenditure.setDepartmentJoinTwo(department);
		
		//department.getExpenditure().add(expenditure);		
		
		idd.insertExpend(expenditure,department);
		
		// Update balance in allocation table 
		
		idd.updateAllocation(expenseType, expend, department.getDeptID());
		session.setAttribute("pageName", "UserFinal");
		return "UserFinal";
	}

	@RequestMapping(value = "/UserConfirm", method = RequestMethod.POST)
	public String userConfirm(ModelMap modelMap, HttpServletRequest request) {
		modelMap.addAttribute("LogSuccess", logoff);
		HttpSession session = request.getSession();
		session.setAttribute("pageName", "UserHome");
		return "UserHome";
	}

}
