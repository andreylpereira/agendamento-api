package com.senai.api.controllers;

import java.sql.Date;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.api.dto.AgendaDto;
import com.senai.api.services.AgendaService;

@RestController
@RequestMapping("/api")
public class AgendaController {

	@Autowired
	private AgendaService agendaService;


	@GetMapping("/agenda")
	public ResponseEntity<?> getAgenda(@RequestParam(required = false) Date data,
	        @RequestParam(required = false) Time hora) {
	    return agendaService.listarAgenda(data, hora);
	}


	@PostMapping("/agenda")
	public ResponseEntity<?> insertAgenda(@RequestBody AgendaDto agendaDto) {
		return agendaService.agendar(agendaDto);
	}

	@PutMapping("/agenda/{id}")
	public ResponseEntity<?> UpdateAgenda(@RequestBody AgendaDto agendaDto, @PathVariable int id) {
		return agendaService.editarAgendamento(agendaDto, id);
	}

	@DeleteMapping("/agenda/{id}")
	public ResponseEntity<?> UpdateAgenda(@PathVariable int id) {
		return agendaService.desagendar(id);
	}

}
