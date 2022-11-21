package com.encuentro.matrimonial.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.encuentro.matrimonial.modelo.SegundoPilar;

public interface ISegundoPilarRepository extends CrudRepository<SegundoPilar, Long> {

	@Query("Select u FROM segundo_pilar u WHERE u.id = :id")
	SegundoPilar findBySegundoPilar(@Param("id") Long id);

	@Query("Select u FROM segundo_pilar u WHERE u.fechaCreacion = :fecha")
	SegundoPilar findByFiltroSegundoPilar(@Param("fecha") String fecha);

}
