package com.encuentro.matrimonial.modelo;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Estado_lote")
public class Estado_lote {

	@Id
	@Column
	private Long id;

	@Column(nullable = false)
	private String estado;




}
