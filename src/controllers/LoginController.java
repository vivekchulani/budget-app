package controllers;

import hibernate.Department;
import hibernate.Employees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import business.IDAODelegate;

	@Controller
public class LoginController {
	
	private String errorMessage = "Username and Password do not match!";
	private String errorMessageOne = "Username does not exist! Please register!";

	@Autowired
	IDAODelegate idd;

//	public void setIdd(IDAODelegate idd) {
//		this.idd = idd;
//	}

	@Autowired
	Employees employees;
	
	@RequestMapping(value = "/LoginSubmit", method = RequestMethod.POST)
	public String enterEmployee(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//System.out.println(username);
		//System.out.println(password);
		Map<String, String> employeeMap = new HashMap<String, String>();
		List<Employees> empList = null;
		empList = (List<Employees>) idd.checkEmployees();
		
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = empList.iterator(); iterator.hasNext();) {
			Employees employees = (Employees) iterator.next();
			// System.out.println(employees.getUsername());
			// System.out.println(employees.getPassword())
			employeeMap.put(employees.getUsername(), employees.getPassword());
		}
		HttpSession session = request.getSession();
		if (username.equals("admin") && password.equals("password")){
			session.setAttribute("pageName", "AdminHome");
			return "AdminHome";
		} else if ((username.equals("finmember") && password.equals("finmember"))){
			session.setAttribute("pageName", "FinHome");
			return "FinHome";
		} else if ((username.equals("finmember1") && password.equals("finmember1"))){
			session.setAttribute("pageName", "FinHome");
			return "FinHome";
		} else if (employeeMap.containsKey(username)) {
			if (password.equals(employeeMap.get(username))) {
				// Get department id from BudgetConUsers table and store in session *
				Employees employees = null;
				for (@SuppressWarnings("rawtypes")
				Iterator iterator = empList.iterator(); iterator.hasNext();) {
					employees = (Employees) iterator.next();
					if (employees.getUsername().equals(username)){
						break;
					}
				}
				
				session.setAttribute("deptID", employees.getDepartmentJoinThree());
				session.setAttribute("pageName", "UserHome");
				return "UserHome";
			} else 
				modelMap.addAttribute("ERR", errorMessage);
			session.setAttribute("pageName", "Login");
				return "Login";
		} else 
				modelMap.addAttribute("ERR1", errorMessageOne);
		session.setAttribute("pageName", "Login");
			return "Login";
	}
	@RequestMapping(value = "/RegSubmit", method = RequestMethod.POST)
	public String registerEmployee(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("pageName", "Register");
		return "Register";
	}
	
	@RequestMapping(value="/redirect")
	public String reDirect(ModelMap modelMap, HttpServletRequest request){
		
		Map<Long, String> dMap = idd.retrieveDeptNames();
		
		System.out.println(dMap);
		
		HttpSession sessionObj = request.getSession();
		sessionObj.setAttribute("first" ,  dMap.get(1L)) ;
		sessionObj.setAttribute("second" ,  dMap.get(2L)) ;
		sessionObj.setAttribute("third" ,  dMap.get(3L)) ;
		sessionObj.setAttribute("fourth" ,  dMap.get(4L)) ;
		sessionObj.setAttribute("fifth" ,  dMap.get(5L)) ;
		sessionObj.setAttribute("sixth" ,  dMap.get(6L)) ;
		sessionObj.setAttribute("seventh" ,  dMap.get(7L)) ;
		sessionObj.setAttribute("eigth" ,  dMap.get(8L)) ;
		
		ConversionController.setCurrencies(request);
		sessionObj.setAttribute("pageName", "Login");
		return "Login";
	}
	

}
