package com.encuentro.matrimonial.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.encuentro.matrimonial.constants.ResourceMapping;
import com.encuentro.matrimonial.modelo.AddressList;
import com.encuentro.matrimonial.modelo.CentroSalud;
import com.encuentro.matrimonial.modelo.Location;
import com.encuentro.matrimonial.modelo.ResponseMicroservicio;
import com.encuentro.matrimonial.service.ICentroSaludService;
import com.encuentro.matrimonial.util.ErrorMessage;
import com.encuentro.matrimonial.util.ErrorMessage2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(ResourceMapping.LOCATION)
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.OPTIONS }, allowedHeaders = "*")
public class sigres {

	@Autowired
	private ICentroSaludService centroService;

	@GetMapping()
	public ResponseEntity<?> saludo() {
		return new ResponseEntity<>(new ErrorMessage2(0, "Bienvenidos al sistema covid!"), HttpStatus.OK);
	}

	@RequestMapping(value = "/getCentroCercano", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> getLocation(@RequestBody Location loc) throws JsonProcessingException {
		try {
			List<CentroSalud> listado = centroService.getCentros();
			if (listado == null) {
				return new ResponseEntity(new ErrorMessage2(1, "No sea encontrado ningun centro de salud disponible"),
						HttpStatus.OK);
			}
			ArrayList<AddressList> a = new ArrayList<AddressList>();
			for (int i = 0; i < listado.size(); i++) {
				AddressList b = new AddressList();
				b.setAddress(listado.get(i).getDireccion());
				b.setId(listado.get(i).getId());
				a.add(b);
				loc.setAddressList(a);
			}
			String uri = "https://seim-location.azurewebsites.net/location";
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(loc);

			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Type", "application/json");
			HttpEntity requestEntity = new HttpEntity(json, headers);
			ResponseEntity<ResponseMicroservicio> addedRes = restTemplate.exchange(uri, HttpMethod.POST, requestEntity,
					ResponseMicroservicio.class);
			return new ResponseEntity(new ErrorMessage(0, "Centro de salud mas cercano", addedRes.getBody()),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity(new ErrorMessage2(10, "Error Temporal"), HttpStatus.OK);
		}

	}
}
