package com.jpa.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.demo.entitites.Employe;
import com.jpa.demo.repository.EmpRepo;

@Service
public class EmpService {
	
	
	@Autowired
	private EmpRepo repo;
	
	
	public void addEmp(Employe e) {
		repo.save(e);
	}

	public List<Employe> getAllEmp(){
		return repo.findAll();
	}
	
	public Employe getEmpById(int id) {
	 Optional<Employe> e=repo.findById(id);
	 if(e.isPresent()) {
		 return e.get();
	 }
	 return null;
	}
	
	
	public void deleteEmp(int id) {
		repo.deleteById(id);
	}
}
