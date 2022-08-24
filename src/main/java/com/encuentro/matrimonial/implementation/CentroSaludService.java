package com.encuentro.matrimonial.implementation;

import com.encuentro.matrimonial.modelo.CentroSalud;
import com.encuentro.matrimonial.modelo.Laboratorio;
import com.encuentro.matrimonial.repository.ICentroSalud;
import com.encuentro.matrimonial.repository.ILaboratorioRepository;
import com.encuentro.matrimonial.service.ICentroSaludService;
import com.encuentro.matrimonial.service.ILaboratorioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentroSaludService implements ICentroSaludService {

	@Autowired
	private ICentroSalud centroDao;

	@Override
	public List<CentroSalud> getCentros() {
		return centroDao.findAll();
	}

	@Override
	public CentroSalud updateCentro(CentroSalud centro) {
		return centroDao.save(centro);
	}

	@Override
	public CentroSalud findByC(Long id) {
		return centroDao.findByC(id);
	}

	@Override
	public CentroSalud findByCentro(String centro) {
		return centroDao.findByCentro(centro);
	}

}
