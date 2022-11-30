package com.superapp.pqrs.service;

import java.util.List;
import java.util.Optional;

import com.superapp.pqrs.modelo.Usuario;

public interface IUserService {

	List<Usuario> getUsuarios();

	void createUsuario(Usuario user);

	Usuario updateUsuario(Usuario user);

	void deleteUsuario(Long id);

	Optional<Usuario> findByIdUsuario(Long id);

	Usuario findByUser(String user);

	Usuario findByLogin(String user, String pass);

	Usuario findBy(Long id);

	Usuario findByDocumento(String doc);

}