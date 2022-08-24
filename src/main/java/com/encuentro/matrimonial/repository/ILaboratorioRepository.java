package com.encuentro.matrimonial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.encuentro.matrimonial.modelo.Laboratorio;


public interface ILaboratorioRepository extends JpaRepository<Laboratorio, Integer> {

	
}
