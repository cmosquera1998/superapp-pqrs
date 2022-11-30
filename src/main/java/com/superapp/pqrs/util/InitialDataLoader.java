package com.superapp.pqrs.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.superapp.pqrs.modelo.*;
import com.superapp.pqrs.repository.*;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IPqrsRepository pqrsRepository;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;

		if (userRepository.findByUser("1007064254") == null) {
			Usuario user = new Usuario(0L, "Super", "admin", "cmosquerara@unbosque.edu.co", "3218609938", "admin",
					"1007064254", true, "G");

			Pqrs pq = new Pqrs(0L, "Peticion", "Nuevo", "Pqrs de prueba", "Prueba inicial", 1007064254L, "");

			Pqrs pq1 = new Pqrs(0L, "Peticion 2", "Nuevo", "Pqrs de prueba 2", "Prueba  2", 1007064254L, "");

			Pqrs pq2 = new Pqrs(0L, "Reclamo", "Nuevo", "Pqrs de prueba 3", "Prueba  3", 100L, "");
			userRepository.save(user);
			pqrsRepository.save(pq);
			pqrsRepository.save(pq1);
			pqrsRepository.save(pq2);
		}
		alreadySetup = true;
	}

}
