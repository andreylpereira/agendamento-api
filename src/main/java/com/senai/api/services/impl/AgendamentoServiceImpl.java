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

import com.senai.api.dto.AgendamentoDto;
import com.senai.api.models.Agendamento;
import com.senai.api.models.Usuario;
import com.senai.api.repository.AgendamentoRepository;
import com.senai.api.services.AgendamentoService;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@Override
	public ResponseEntity<?> listarAgenda(Date data, Time hora) {
		{
			List<Agendamento> agendaFiltrada = new ArrayList<>();

			if (data != null && hora != null) {
				agendaFiltrada = agendamentoRepository.findByDataAndHora(data, hora);
			} else if (data != null) {
				agendaFiltrada = agendamentoRepository.findByData(data);
			} else if (hora != null) {
				agendaFiltrada = agendamentoRepository.findByHora(hora);
			} else {
				agendaFiltrada = agendamentoRepository.findAll();
			}

			return ResponseEntity.ok(agendaFiltrada);
		}
	}

	@Override
	public ResponseEntity<?> agendar(AgendamentoDto agendamentoDto, int usuario_id) {

		try {
			Usuario usuario = new Usuario();
			usuario.setId(usuario_id);

			Agendamento agendamento = new Agendamento();
			BeanUtils.copyProperties(agendamentoDto, agendamento);
			agendamento.setUsuario(usuario);
			agendamentoRepository.save(agendamento);
			return ResponseEntity.ok("Agendamento realizado com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.ok("Não foi possível realizar o agendamento.");
		}
	}

	@Override
	public ResponseEntity<?> editarAgendamento(AgendamentoDto agendamentoDto, int agendamento_id) {
		Optional<Agendamento> dataAgenda = agendamentoRepository.findById(agendamento_id);

		if (dataAgenda.isPresent()) {
			Agendamento agendamento = new Agendamento();
			BeanUtils.copyProperties(agendamentoDto, agendamento);
			Usuario usuario = dataAgenda.get().getUsuario();

			agendamento.setUsuario(usuario);
			agendamento.setId(agendamento_id);
			agendamentoRepository.save(agendamento);
			return ResponseEntity.ok("Agendamento atualizado com sucesso!");
		}
		return ResponseEntity.ok("Não foi possivel atualizar.");
	}

	@Override
	public ResponseEntity<?> desagendar(int agendamento_id) {
		Optional<Agendamento> dataAgenda = agendamentoRepository.findById(agendamento_id);

		if (dataAgenda.isPresent()) {
			agendamentoRepository.deleteById(agendamento_id);
			return ResponseEntity.ok("Agendamento desmarcado com sucesso!");
		}
		return ResponseEntity.ok("Não foi desagendar.");
	}

}
