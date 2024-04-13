package com.senai.api.services;

import java.sql.Date;
import java.sql.Time;

import org.springframework.http.ResponseEntity;

import com.senai.api.dto.AgendaDto;

public interface AgendaService {

	ResponseEntity<?> listarAgenda(Date data, Time hora);

	ResponseEntity<?> agendar(AgendaDto agendaDto);

	ResponseEntity<?> editarAgendamento(AgendaDto agendaDto, int id);

	ResponseEntity<?> desagendar(int id);

}
