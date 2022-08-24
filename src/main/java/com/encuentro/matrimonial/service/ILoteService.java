package com.encuentro.matrimonial.service;

import java.util.List;
import java.util.Optional;

import com.encuentro.matrimonial.modelo.Lote;
import com.encuentro.matrimonial.modelo.Usuario;

public interface ILoteService {

	List<Lote> getLotes();

	void createLote(Lote user);

	Lote updateLote(Lote user);

	void deleteLote(Long id);

	Optional<Lote> findByIdLote(Long id);

	Lote findByLote(Long lote);

	Lote findBy(Long lot);

}
