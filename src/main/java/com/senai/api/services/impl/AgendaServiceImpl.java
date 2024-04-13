package com.senai.api.services.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.senai.api.dto.AgendaDto;
import com.senai.api.models.Agenda;
import com.senai.api.repository.AgendaRepository;
import com.senai.api.services.AgendaService;

@Service
public class AgendaServiceImpl implements AgendaService {

	@Autowired
	private AgendaRepository agendaRepository;

	@Override
	public ResponseEntity<?> listarAgenda(Date data, Time hora) {
		{
			List<Agenda> agendaFiltrada = new ArrayList<>();
			
			if (data != null && hora != null) {
				agendaFiltrada = agendaRepository.findByDataAndHora(data, hora);
			}
			else if (data != null) {
				agendaFiltrada = agendaRepository.findByData(data);
			}
			else if (hora != null) {
				agendaFiltrada = agendaRepository.findByHora(hora);
			}
			else {
				agendaFiltrada = agendaRepository.findAll();
			}
			
			return ResponseEntity.ok(agendaFiltrada);
		}
	}

	@Override
	public ResponseEntity<?> agendar(AgendaDto agendaDto) {
		try {
			Agenda agenda = new Agenda();
			BeanUtils.copyProperties(agendaDto, agenda);
			agendaRepository.save(agenda);
			return ResponseEntity.ok("Agendamento realizado com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.ok("Não foi realizar o agendamento.");
		}
	}

	@Override
	public ResponseEntity<?> editarAgendamento(AgendaDto agendaDto, int id) {
		Optional<Agenda> dataAgenda = agendaRepository.findById(id);

		if (dataAgenda.isPresent()) {
			Agenda agenda = new Agenda();
			BeanUtils.copyProperties(agendaDto, agenda);
			agenda.setId(id);
			agendaRepository.save(agenda);
			return ResponseEntity.ok("Agendamento atualizado com sucesso!");
		}
		return ResponseEntity.ok("Não foi possivel atualizar.");
	}

	@Override
	public ResponseEntity<?> desagendar(int id) {
		Optional<Agenda> dataAgenda = agendaRepository.findById(id);

		if (dataAgenda.isPresent()) {
			agendaRepository.deleteById(id);
			return ResponseEntity.ok("Agendamento desmarcado com sucesso!");
		}
		return ResponseEntity.ok("Não foi desagendar.");
	}

}
