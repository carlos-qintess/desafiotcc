package com.qintess.tarefas.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.qintess.tarefas.entidades.Tarefa;

public interface TarefaRepository extends CrudRepository<Tarefa, Integer> {

}
