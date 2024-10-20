package com.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.demo.entitites.Employe; // Ensure this import is correct


@Repository
public interface EmpRepo extends JpaRepository<Employe,Integer> {
    
}
