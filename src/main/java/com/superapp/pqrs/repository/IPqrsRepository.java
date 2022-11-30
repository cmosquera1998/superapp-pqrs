package com.superapp.pqrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.superapp.pqrs.modelo.Pqrs;

public interface IPqrsRepository extends CrudRepository<Pqrs, Long> {

	@Query("Select u FROM pqrs u WHERE u.id = :id")
	Pqrs findByPqrs(@Param("id") Long id);
	
	@Query("Select u FROM pqrs u WHERE u.idUser = :id")
	List<Pqrs> findByPqrsUser(@Param("id") Long id);

}
