package com.superapp.pqrs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.superapp.pqrs.constants.ResourceMapping;
import com.superapp.pqrs.modelo.Usuario;
import com.superapp.pqrs.service.IUserService;
import com.superapp.pqrs.util.ErrorMessage;
import com.superapp.pqrs.util.ErrorMessage2;

@RestController
@RequestMapping(ResourceMapping.USER)
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.OPTIONS }, allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private IUserService userService;


	// servicio que trae el listado de usuarios
	@RequestMapping(value = "/getUsuarios", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<ErrorMessage<List<Usuario>>> getUser() {
		List<Usuario> listado = userService.getUsuarios();
		ErrorMessage<List<Usuario>> error = listado.isEmpty()
				? new ErrorMessage<>(1, "No se ha encontrado información", null)
				: new ErrorMessage<>(0, "Lista de Usuarios", listado);
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

	// servicio para crear un usuario
	@RequestMapping(value = "/createUsuario", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createUser(@RequestBody Usuario user) {
		Usuario user2 = userService.findByUser(user.getCorreo());
		Usuario user3 = userService.findByDocumento(user.getDocument());
		if (user2 != null || user3 != null) {
			return new ResponseEntity(new ErrorMessage2(1, "El usuario ya se encuentra registrado"), HttpStatus.OK);
		}

		if (user.getNombres().isEmpty() || user.getApellidos().isEmpty()) {
			return new ResponseEntity(new ErrorMessage2(2, "información incompleta"), HttpStatus.OK);
		}
		if(user.getPerfil() !=null) {
			user.setPerfil("G");
		}else {
			user.setPerfil("S");
		}
		user.setState(true);
		userService.createUsuario(user);
		return new ResponseEntity(new ErrorMessage2(0, "Usuario creado con exito!"), HttpStatus.OK);
	}

	//servicio para actualizar un usuario
	@RequestMapping(value = "/updateUsuario", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> updateUsuario(@RequestBody Usuario user) {
		Optional<Usuario> us = userService.findByIdUsuario(user.getId());
		if (!us.isPresent()) {
			return new ResponseEntity(new ErrorMessage2(1, "No sea encontrado el usuario"), HttpStatus.OK);
		}
		// user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.updateUsuario(user);
		return new ResponseEntity(new ErrorMessage2(0, "Usuario actualizado con exito!"), HttpStatus.OK);
	}

	// servicio para desactivar un usuario
	@RequestMapping(value = "/deleteUsuario", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> deleteUsuario(@RequestBody Usuario user) {
		Usuario us = userService.findBy(user.getId());
		System.out.println(us);
		if (us == null) {
			return new ResponseEntity(new ErrorMessage2(1, "No sea encontrado el usuario"), HttpStatus.OK);
		}
		if (us.getState() == true) {
			us.setState(false);
		}
		userService.updateUsuario(us);
		return new ResponseEntity(new ErrorMessage2(0, "Usuario desactivado con exito!"), HttpStatus.OK);
	}

}
