package controllers;

import hibernate.Allocation;
import hibernate.Department;
import hibernate.Expenditure;

import java.util.Collections;
import java.util.Comparator;
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
public class FinHomeController {

	@Autowired
	IDAODelegate idd;


//	public void setIdd(IDAODelegate idd) {
//		this.idd = idd;
//	}

	@RequestMapping(value = "/FinSubmitOne", method = RequestMethod.POST)
	public String finSubmit(ModelMap modelMap, HttpServletRequest request) {

		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String department = request.getParameter("department");

		Department deptObj = idd.retrieveDepartment(department);
		//System.out.println(deptObj.getDeptID());
		Long deptID = deptObj.getDeptID();
		System.out.println(deptID);

		List<Expenditure> eList = idd.retrieveFin(startDate, endDate, deptID);
		
		List<Allocation> aList = idd.retrieveAll(deptID);
		
		Collections.sort(eList, new Comparator<Expenditure>() {

			@Override
			public int compare(Expenditure expenditure, Expenditure expenditures) {

				return (expenditure.getExpenseDate().compareTo(expenditures.getExpenseDate()));
			}
		});
		
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = eList.iterator(); iterator.hasNext();) {
			@SuppressWarnings("unused")
			Expenditure expenditure = (Expenditure) iterator.next();
		}
		
		modelMap.addAttribute("expend", eList);
		modelMap.addAttribute("sDate", startDate);
		modelMap.addAttribute("eDate", endDate);
		modelMap.addAttribute("all", aList);
		HttpSession session = request.getSession();
		session.setAttribute("pageName", "FinFinal");
		return "FinFinal";
	}
	
	@RequestMapping(value="/FinBack", method=RequestMethod.POST)
	public String finBack(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("pageName", "FinHome");
		return "FinHome";
	}
	
}
