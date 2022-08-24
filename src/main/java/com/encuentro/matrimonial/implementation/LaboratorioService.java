package com.encuentro.matrimonial.implementation;

import com.encuentro.matrimonial.modelo.Laboratorio;
import com.encuentro.matrimonial.repository.ILaboratorioRepository;
import com.encuentro.matrimonial.service.ILaboratorioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratorioService implements ILaboratorioService {

	@Autowired
	private ILaboratorioRepository laboratorioDao;

	@Override
	public List<Laboratorio> getLaboratorios() {
		return laboratorioDao.findAll();
	}

}
