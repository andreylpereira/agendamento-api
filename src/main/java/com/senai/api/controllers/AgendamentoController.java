package com.senai.api.controllers;

import java.sql.Date;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.api.dto.AgendamentoDto;
import com.senai.api.services.AgendamentoService;

@RestController
@RequestMapping("/api")
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendaService;


	@GetMapping("/agenda")
	public ResponseEntity<?> getAgenda(@RequestParam(required = false) Date data,
	        @RequestParam(required = false) Time hora) {
	    return agendaService.listarAgenda(data, hora);
	}

	@PostMapping("/agenda/{usuario_id}")
	public ResponseEntity<?> insertAgenda(@RequestBody AgendamentoDto agendaDto, @PathVariable int usuario_id) {
		return agendaService.agendar(agendaDto, usuario_id);
	}

	@PutMapping("/agenda/{agendamento_id}")
	public ResponseEntity<?> UpdateAgenda(@RequestBody AgendamentoDto agendaDto, @PathVariable int agendamento_id) {
		return agendaService.editarAgendamento(agendaDto, agendamento_id);
	}

	@DeleteMapping("/agenda/{agendamento_id}")
	public ResponseEntity<?> UpdateAgenda(@PathVariable int agendamento_id) {
		return agendaService.desagendar(agendamento_id);
	}

}
