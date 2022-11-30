package com.superapp.pqrs.service.implementation;

import com.superapp.pqrs.modelo.Pqrs;
import com.superapp.pqrs.repository.IPqrsRepository;
import com.superapp.pqrs.service.IPqrsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PqrsService implements IPqrsService {

	@Autowired
	IPqrsRepository pqrsDTO;

	@Override
	public void create(Pqrs pqrs) {
		pqrsDTO.save(pqrs);
	}

	@Override
	public List<Pqrs> getAll() {
		return (List<Pqrs>) pqrsDTO.findAll();
	}

	@Override
	public Pqrs findByPqrs(Long id) {
		return pqrsDTO.findByPqrs(id);
	}

	@Override
	public Pqrs update(Pqrs pqrs) {
		return pqrsDTO.save(pqrs);
	}

	@Override
	public void delete(Long id) {
		pqrsDTO.deleteById(id);
	}

	@Override
	public List<Pqrs> findByPqrsUser(Long document) {
		return (List<Pqrs>) pqrsDTO.findByPqrsUser(document);
	}

}
