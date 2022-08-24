package com.encuentro.matrimonial.service;

import java.util.List;

import com.encuentro.matrimonial.modelo.Paciente;

public interface IPacienteService {

	List<Paciente> getPacientes();

	Paciente findBy(Long id);

	List<Paciente> findByCentro(Long id_centro);
	
	Paciente updatePaciente(Paciente pac);

}
