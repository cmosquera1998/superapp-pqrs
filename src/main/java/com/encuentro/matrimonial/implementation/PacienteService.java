package com.encuentro.matrimonial.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encuentro.matrimonial.modelo.Paciente;
import com.encuentro.matrimonial.repository.IPacienteRepository;
import com.encuentro.matrimonial.service.IPacienteService;

@Service
public class PacienteService implements IPacienteService {

	@Autowired
	private IPacienteRepository pacienteDao;

	@Override
	public List<Paciente> getPacientes() {
		return (List<Paciente>) pacienteDao.findAll();
	}

	@Override
	public Paciente findBy(Long id) {
		return pacienteDao.findBy(id);
	}

	@Override
	public List<Paciente> findByCentro(Long id_centro) {
		return (List<Paciente>) pacienteDao.findByCentro(id_centro);
	}

	@Override
	public Paciente updatePaciente(Paciente pac) {
		return pacienteDao.save(pac);
	}

}
