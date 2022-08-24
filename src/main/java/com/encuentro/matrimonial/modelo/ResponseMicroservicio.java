package com.encuentro.matrimonial.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class ResponseMicroservicio {

	private boolean error;
	private double x;
	private double y;
	private String distance;
	private String id;
	private String address;

}
