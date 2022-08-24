package com.encuentro.matrimonial.service;

import java.util.List;

import com.encuentro.matrimonial.modelo.CentroSalud;

public interface ICentroSaludService {

	List<CentroSalud> getCentros();

	CentroSalud updateCentro(CentroSalud centro);

	CentroSalud findByC(Long centro);

	CentroSalud findByCentro(String centro);
}
