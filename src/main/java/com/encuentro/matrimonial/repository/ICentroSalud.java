package com.encuentro.matrimonial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.encuentro.matrimonial.modelo.CentroSalud;
import com.encuentro.matrimonial.modelo.Usuario;

public interface ICentroSalud extends JpaRepository<CentroSalud, Integer> {

	@Query("Select c FROM centro_salud c WHERE c.id = :centro")
	CentroSalud findByC(@Param("centro") Long id);

	@Query("Select c FROM centro_salud c WHERE c.direccion = :centro")
	CentroSalud findByCentro(@Param("centro") String centro);
}
