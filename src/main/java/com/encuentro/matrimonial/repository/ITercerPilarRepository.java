package com.encuentro.matrimonial.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.encuentro.matrimonial.modelo.TercerPilar;

public interface ITercerPilarRepository extends CrudRepository<TercerPilar, Long> {

	@Query("Select u FROM tercer_pilar u WHERE u.id = :id")
	TercerPilar findByTercerPilar(@Param("id") Long id);

	@Query("Select u FROM tercer_pilar u WHERE u.fechaCreacion = :fecha")
	TercerPilar findByFiltroTercerPilar(@Param("fecha") String fecha);

}
