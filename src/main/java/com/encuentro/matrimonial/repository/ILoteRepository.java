package com.encuentro.matrimonial.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.encuentro.matrimonial.modelo.Lote;

public interface ILoteRepository extends CrudRepository<Lote, Long> {

	@Query("Select u FROM Lote u WHERE u.numero = :lote")
	Lote findByLote(@Param("lote") int lote);


	@Query("Select u FROM Lote u WHERE u.id = :id")
	Lote findBy(@Param("id") Long id);
  
    @Query("Select u FROM Lote u WHERE u.id = :lote")
    Lote findByLote(@Param("lote") Long lote);
}
