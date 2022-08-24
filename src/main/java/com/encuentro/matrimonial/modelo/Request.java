package com.encuentro.matrimonial.modelo;


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
public class Request {

	private String Tag1;

	private String Tag2;

	private String TagN;

}
