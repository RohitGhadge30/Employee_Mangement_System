package com.jpa.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jpa.demo.entitites.Employe;
import com.jpa.demo.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	
	@GetMapping("/home")
	public String Emp(Model m) {
		List<Employe> employes=service.getAllEmp();
		m.addAttribute("emp",employes);
		return "index";
	}
	
	
	@GetMapping("/addemp")
	public String addEmp() {
		return "add_emp";
	}

	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employe e,HttpSession session) {
		System.out.print(e);
		service.addEmp(e);
		session.setAttribute("msg", "Emp Added SuccessFully...");	
		return "redirect:/home";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		
		Employe e=service.getEmpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employe e,HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Emp Data Update Successfully");
		return "redirect:/home";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteMap(@PathVariable int id,HttpSession session){
		
		service.deleteEmp(id);
		session.setAttribute("msg", "Emp Data Delete Successfully");
		return "redirect:/home";
	}
	
		
	
	
	
}
