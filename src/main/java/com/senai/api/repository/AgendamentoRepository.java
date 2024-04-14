package com.senai.api.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.api.models.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

	List<Agendamento> findByDataAndHora(Date data, Time hora);

	List<Agendamento> findByData(Date data);

	List<Agendamento> findByHora(Time hora);

}