package com.encuentro.matrimonial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuentro.matrimonial.modelo.Etapa;
import com.encuentro.matrimonial.modelo.Ocupacion;

public interface IOcupacion extends JpaRepository<Ocupacion, Integer> {

}
