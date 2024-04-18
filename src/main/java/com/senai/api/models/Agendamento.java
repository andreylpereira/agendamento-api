package com.senai.api.models;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "agenda")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private Date data;
	private Time hora;
	private String observacao;
	private String contato;
	private Time inicioAtendimento;
	private Time fimAtendimento;

	@ManyToOne
	@JsonIgnore
	private Usuario usuario;

	public Agendamento() {
	}

	public Agendamento(int id, String titulo, Date data, Time hora, String observacao, String contato,
			Time inicioAtendimento, Time fimAtendimento, Usuario usuario) {
		this.id = id;
		this.titulo = titulo;
		this.data = data;
		this.hora = hora;
		this.observacao = observacao;
		this.contato = contato;
		this.inicioAtendimento = inicioAtendimento;
		this.fimAtendimento = fimAtendimento;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Time getInicioAtendimento() {
		return inicioAtendimento;
	}

	public void setInicioAtendimento(Time inicioAtendimento) {
		this.inicioAtendimento = inicioAtendimento;
	}

	public Time getFimAtendimento() {
		return fimAtendimento;
	}

	public void setFimAtendimento(Time fimAtendimento) {
		this.fimAtendimento = fimAtendimento;
	}

}
