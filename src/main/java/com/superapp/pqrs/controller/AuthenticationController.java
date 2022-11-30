package com.superapp.pqrs.controller;

import com.superapp.pqrs.constants.Mensaje;
import com.superapp.pqrs.constants.ResourceMapping;
import com.superapp.pqrs.modelo.AuthenticationRequest;
import com.superapp.pqrs.modelo.AuthenticationResponse;
import com.superapp.pqrs.modelo.Usuario;
import com.superapp.pqrs.repository.IUserRepository;
import com.superapp.pqrs.util.ErrorMessage2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.OPTIONS }, allowedHeaders = "*")
public class AuthenticationController {

	@Autowired
	private IUserRepository userRepository;

	@PostMapping(ResourceMapping.LOGIN)
	public ResponseEntity<?> login(@RequestBody AuthenticationRequest usuario) throws Exception {
		try {
			Usuario isLogin = userRepository.findByLogin(usuario.getUsername(), usuario.getPassword());
			if (isLogin == null) {
				return ResponseEntity
						.ok(new ErrorMessage2(Mensaje.CODE_UNAUTHORIZED, Mensaje.CREDENCIALES_INCORRECTAS));
			}

		} catch (Exception e) {
			return ResponseEntity.ok(new ErrorMessage2(Mensaje.CODE_UNAUTHORIZED, Mensaje.CREDENCIALES_INCORRECTAS));
		}

		Usuario user = userRepository.findByUser(usuario.getUsername());

		return ResponseEntity.ok(new AuthenticationResponse(user));
	}

}
