/*package com.encuentro.matrimonial.controller;

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


import com.encuentro.matrimonial.modelo.Request;
import com.encuentro.matrimonial.util.ErrorMessage;
import com.encuentro.matrimonial.util.ErrorMessage2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.OPTIONS }, allowedHeaders = "*")
public class MicroServiceController {

	@Autowired
	private ICentroSaludService centroService;

	@GetMapping()
	public ResponseEntity<?> saludo() {
		return new ResponseEntity<>(new ErrorMessage2(0, "Bienvenido!"), HttpStatus.OK);
	}

	@RequestMapping(value = "/notificarSigres", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> getLocation(@RequestBody Request req) throws JsonProcessingException {
		//public ResponseEntity<?> getLocation(@RequestBody RequestSigres req) throws JsonProcessingException {
		try {
			String uri = "https://seim-location.azurewebsites.net/location";
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();
			String body = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(req);
			System.out.println("Objecto que se envia:" + body);
			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Type", "application/json");
			HttpEntity request = new HttpEntity(body, headers);
			ResponseEntity<?> addedRes = restTemplate.exchange(uri, HttpMethod.POST, requestEntity);
			System.out.println("responde " + addedRes);
			return new ResponseEntity(new ErrorMessage(0, "Centro de salud mas cercano", addedRes.getBody()),
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity(new ErrorMessage2(10, "Error Temporal"), HttpStatus.OK);
		}

	}
}
*/