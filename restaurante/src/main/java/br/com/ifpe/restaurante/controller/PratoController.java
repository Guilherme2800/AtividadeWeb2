package br.com.ifpe.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.restaurante.model.Prato;
import br.com.ifpe.restaurante.repository.PratoRepository;

@Controller
@RequestMapping("prato")
public class PratoController {

	@Autowired
	PratoRepository pratoRepository;
	
	@Autowired
	HomeController homeController;
	
	@GetMapping("cadastroTela")
	public String telaCadastro() {
		return "prato/telaCadastro";
	}
	
	@PostMapping("cadastrar")
	public String cadastrar(Model model, Prato prato) {
		pratoRepository.save(prato);
		return homeController.telaHome(model);
	}
	
}
