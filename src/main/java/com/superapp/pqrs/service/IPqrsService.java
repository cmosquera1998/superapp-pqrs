package com.superapp.pqrs.service;

import java.util.List;

import com.superapp.pqrs.modelo.Pqrs;

public interface IPqrsService {

	void create(Pqrs pqrs);

	List<Pqrs> getAll();

	Pqrs findByPqrs(Long id);

	Pqrs update(Pqrs pqrs);

	void delete(Long id);
	
	List<Pqrs> findByPqrsUser(Long document);

}
