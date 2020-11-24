package com.qintess.tarefas.controllers.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.qintess.tarefas.entidades.Tarefa;

public class TarefaDto {

	private int id;
	
	@NotNull
	@NotBlank(message = "O campo nome não pode ser vazio.")
	private String nome;
	
	@NotNull
	@NotBlank(message = "O campo descrição não pode ser vazio.")
	private String descricao;
	
	@NotNull
	@NotBlank(message = "O campo data agendamento não pode ser vazio.")
	private String dataAgendamento;
	
	private String dataCriacao;
	
	private boolean finalizada;
	
	private String dataFinalizada;

	public TarefaDto() {
	}
	
	public TarefaDto(Tarefa t) {
		this.id = t.getId();
		this.nome = t.getNome();
		this.descricao = t.getDescricao();
		this.dataAgendamento = t.getDataAgendamento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.dataCriacao = t.getDataCriacao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.finalizada = t.isFinalizada();
		this.dataFinalizada = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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

	public String getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	
	public String getDataFinalizada() {
		return dataFinalizada;
	}

	public void setDataFinalizada(String dataFinalizada) {
		this.dataFinalizada = dataFinalizada;
	}

	public Tarefa converter() {
		
		var data = LocalDate.parse(this.dataAgendamento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		return new Tarefa(this.id, this.nome, this.descricao, data, finalizada, data);
	}

}
