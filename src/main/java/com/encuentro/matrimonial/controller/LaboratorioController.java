package com.encuentro.matrimonial.controller;

import com.encuentro.matrimonial.constants.ResourceMapping;
import com.encuentro.matrimonial.modelo.Laboratorio;
import com.encuentro.matrimonial.service.ILaboratorioService;
import com.encuentro.matrimonial.util.ErrorMessage;
import com.encuentro.matrimonial.util.ErrorMessage2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ResourceMapping.LABORATORIO)
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.OPTIONS }, allowedHeaders = "*")
public class LaboratorioController {

	@Autowired
	private ILaboratorioService laboratorioService;

	// servicio que trae el listado de Laboratorios
	@GetMapping("/getLaboratorios")
	public ResponseEntity<ErrorMessage<List<Laboratorio>>> getLaboratorio() {
		List<Laboratorio> listado = laboratorioService.getLaboratorios();
		ErrorMessage<List<Laboratorio>> error = listado.isEmpty() ?
				new ErrorMessage<>(1, "No se ha encontrado información",null) :
				new ErrorMessage<>(0, "Lista de Laboratorios", listado);
		return new ResponseEntity<>(error, HttpStatus.OK);
	}


}
