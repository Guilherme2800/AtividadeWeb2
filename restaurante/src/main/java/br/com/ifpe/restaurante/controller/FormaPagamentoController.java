package br.com.ifpe.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.restaurante.model.FormaPagamento;
import br.com.ifpe.restaurante.repository.FormaPagamentoRepository;

@Controller
@RequestMapping("formaPagamento")
public class FormaPagamentoController {

	@Autowired
	HomeController homeController;
	
	@Autowired
	FormaPagamentoRepository formaPagamentoRepository;
	
	@GetMapping("cadastroTela")
	public String cadastroTela() {
		return "formaPagamento/cadastro";
	}
	
	@PostMapping("cadastrar")
	public String cadastrarNovaForma(Model model, FormaPagamento formaPagamento) {
		formaPagamentoRepository.save(formaPagamento);
		return homeController.telaHome(model);
	}
}
