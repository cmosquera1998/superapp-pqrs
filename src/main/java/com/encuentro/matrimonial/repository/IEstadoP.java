package com.encuentro.matrimonial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuentro.matrimonial.modelo.EstadoPaciente;
import com.encuentro.matrimonial.modelo.Etapa;

public interface IEstadoP extends JpaRepository<EstadoPaciente, Integer> {

}
