package com.qintess.tarefas.entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarefa {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	private String descricao;
	
	private LocalDate dataAgendamento;
	
	private LocalDate dataCriacao;
	
	private boolean finalizada;
	
	private LocalDate dataFinalizada;
	
	public Tarefa() {}

	public Tarefa(int id, String nome, String descricao, LocalDate dataAgendamento, boolean finalizada, LocalDate dataFinalizada) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataAgendamento = dataAgendamento;
		this.dataCriacao = LocalDate.now();
		this.finalizada = finalizada;
		this.dataFinalizada = LocalDate.now();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", dataAgendamento="
				+ dataAgendamento + ", dataCriacao=" + dataCriacao + ", finalizada=" + finalizada + ", dataFinalizada="
				+ dataFinalizada + "]";
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	public LocalDate getDataFinalizada() {
		return dataFinalizada;
	}

	public void setDataFinalizada(LocalDate dataFinalizada) {
		this.dataFinalizada = dataFinalizada;
	}
	
}
