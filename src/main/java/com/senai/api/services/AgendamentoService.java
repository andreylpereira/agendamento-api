package com.senai.api.services;

import java.sql.Date;
import java.sql.Time;

import org.springframework.http.ResponseEntity;

import com.senai.api.dto.AgendamentoDto;
import com.senai.api.models.Agendamento;

public interface AgendamentoService {

	ResponseEntity<?> listarAgenda(Date data, Time hora);

	Agendamento agendar(AgendamentoDto agendamentoDto, int usuario_id);

	ResponseEntity<?> editarAgendamento(AgendamentoDto agendaDto, int agendamento_id);

	ResponseEntity<?> desagendar(int agendamento_id);

}
