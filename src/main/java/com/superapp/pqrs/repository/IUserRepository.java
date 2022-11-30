package com.superapp.pqrs.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.superapp.pqrs.modelo.Usuario;

public interface IUserRepository extends CrudRepository<Usuario, Long> {
	
	@Query("Select u FROM Usuario u WHERE u.correo = :user")
	Usuario findByUser(@Param("user") String user);
	
	@Query("Select u FROM Usuario u WHERE u.document = :user")
	Usuario findByDocumento(@Param("user") String user);
	
	@Query("Select u FROM Usuario u WHERE u.correo = :user AND u.contrasena = :pss")
	Usuario findByLogin(@Param("user") String user, @Param("pss") String pss);
	
	@Query("Select u FROM Usuario u WHERE u.id = :user")
	Usuario findBy(@Param("user") Long user);


}
