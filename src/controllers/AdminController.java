package controllers;

import hibernate.Allocation;
import hibernate.Department;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import business.IDAODelegate;

@Controller
public class AdminController {
	
	private String logout = "You have been logged off. Thank you!";
	
	@Autowired
	IDAODelegate idd;
	
//	public void setIdd(IDAODelegate idd) {
//		this.idd = idd;
//	}

	@Autowired
	Allocation allocation;
	

	@RequestMapping(value = "/AdminSubmit", method = RequestMethod.POST)
	public String adminSubmit(ModelMap modelMap, HttpServletRequest request) {

		String amount = request.getParameter("amount");
		Double budget = Double.valueOf(amount);
		String department = request.getParameter("department");
		String allocationDate = request.getParameter("allocationDate");
		System.out.println(amount);
		System.out.println(department);
		
		// Call setters in Allocation POJO
		allocation.setAmount(budget);
		allocation.setAmountDuplicate(budget);
		allocation.setAllocationDate(allocationDate);
		
		Department deptObject = idd.retrieveDepartment(department);
		allocation.setDepartmentJoin(deptObject);
		//deptObject.getAllocation().add(allocation);
		// Call method in business delegate which calls AllocationCRUD method
		idd.insertAllocation(allocation,deptObject);
		
		// Place attributes to retrieve in Administrator Final view 
		modelMap.addAttribute("Dept", department);
		modelMap.addAttribute("Amt", budget);
		modelMap.addAttribute("AllDate", allocationDate);
		HttpSession session = request.getSession();
		session.setAttribute("pageName", "AdminFinal");
		return "AdminFinal";
	}
	
	// 
	@RequestMapping(value="/AdminBack" , method=RequestMethod.POST)
	public String adminLogout(ModelMap modelMap, HttpServletRequest request){
		modelMap.addAttribute("LogOff", logout);
		HttpSession session = request.getSession();
		session.setAttribute("pageName", "AdminHome");
		return "AdminHome";
	}
	
}
