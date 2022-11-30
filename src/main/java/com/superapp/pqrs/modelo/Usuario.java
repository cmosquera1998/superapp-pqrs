package com.superapp.pqrs.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nombres;

	@Column
	private String apellidos;

	@Column(name = "correo", unique = true)
	private String correo;

	@Column
	private String telefono;

	@Column(nullable = false)
	private String contrasena;

	@Column(name = "document", unique = true)
	private String document;

	@Column
	private Boolean state;

	@Column
	private String perfil;


}
