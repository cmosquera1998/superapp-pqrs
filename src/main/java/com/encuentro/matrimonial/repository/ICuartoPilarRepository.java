package com.encuentro.matrimonial.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.encuentro.matrimonial.modelo.CuartoPilar;

public interface ICuartoPilarRepository extends CrudRepository<CuartoPilar, Long> {

	@Query("Select u FROM cuarto_pilar u WHERE u.id = :id")
	CuartoPilar findByCuartoPilar(@Param("id") Long id);

	@Query("Select u FROM cuarto_pilar u WHERE u.fechaCreacion = :fecha")
	CuartoPilar findByFiltroCuartoPilar(@Param("fecha") String fecha);

}
