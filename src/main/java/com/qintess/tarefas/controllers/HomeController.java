package com.qintess.tarefas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.tarefas.controllers.dto.TarefaDto;
import com.qintess.tarefas.repositorios.TarefaRepository;

@Controller
public class HomeController {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@RequestMapping("")
	public String home(Model model) {
		
		model.addAttribute("tarefas", retornaTarefasDto());
		
		return "index";
	}

	private List<TarefaDto> retornaTarefasDto() {
		
		var tarefasDto = new ArrayList<TarefaDto>();
		
		tarefaRepository.findAll().forEach(t -> {
			if (!t.isFinalizada()) {
				tarefasDto.add(new TarefaDto(t));
			}
		});
		
		return tarefasDto;
	}
	
	@RequestMapping("/concluidas")
	public String concluidas(Model model) {
		
		model.addAttribute("tarefas", retornaTarefasConcluidasDto());
		
		return "concluidas";
	}
	
	private List<TarefaDto> retornaTarefasConcluidasDto() {
		
		var tarefasDto = new ArrayList<TarefaDto>();
		
		tarefaRepository.findAll().forEach(t -> {
			if (t.isFinalizada()) {
				tarefasDto.add(new TarefaDto(t));
			}
		});
		
		return tarefasDto;
	}
}
