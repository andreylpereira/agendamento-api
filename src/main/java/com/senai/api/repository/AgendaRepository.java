package com.senai.api.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.api.models.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

	List<Agenda> findByDataAndHora(Date data, Time hora);

	List<Agenda> findByData(Date data);

	List<Agenda> findByHora(Time hora);

}