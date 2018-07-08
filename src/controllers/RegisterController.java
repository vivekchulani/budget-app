package controllers;

import hibernate.Department;
import hibernate.Employees;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import business.IDAODelegate;

@Controller
@RequestMapping("/RegisterSubmit")
public class RegisterController {
	
	private String userErr = "Username already exists! Please enter another!";
	
	@Autowired
	IDAODelegate idd;
	
	
//	public void setIdd(IDAODelegate idd) {
//		this.idd = idd;
//	}


	@Autowired
	Employees employees;
	@Autowired
	Department department;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String registerEmployee(ModelMap modelMap, HttpServletRequest request){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String employeeID = request.getParameter("employeeID");
		String departmentInput = request.getParameter("department");
		System.out.println(departmentInput);
		
		long empID = Long.valueOf(employeeID);
		
		
		List<Employees> employeesList = idd.checkEmployees();
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = employeesList.iterator(); iterator.hasNext();) {
			Employees employees = (Employees) iterator.next();
			if(employees.getUsername().equals(username)){
					modelMap.addAttribute("userError", userErr);
					HttpSession session = request.getSession();
					session.setAttribute("pageName", "Register");
					return "Register";
			}
		}

		// Need to get department ID before persisting
		employees.setUsername(username);
		employees.setPassword(password);
		employees.setEmail(email);
		employees.setEmployeeID(empID);
		
		Department departmentObject = idd.retrieveDepartment(departmentInput);
		System.out.println(departmentObject.getDeptID() + " " + departmentObject.getDepartment());
		employees.setDepartmentJoinThree(departmentObject);
//		departmentObject.getEmployees().add(employees);
//		System.out.println(departmentObject.getDeptID());
		
		idd.insertEmployees(employees,departmentObject);
		HttpSession session = request.getSession();
		session.setAttribute("pageName", "Register");
		return "Login";
	}
	
}
