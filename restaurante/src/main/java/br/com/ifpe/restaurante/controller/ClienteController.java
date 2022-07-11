package br.com.ifpe.restaurante.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.restaurante.model.Cliente;
import br.com.ifpe.restaurante.model.Perfil;
import br.com.ifpe.restaurante.repository.ClienteRepository;
import br.com.ifpe.restaurante.repository.PerfilRepository;

@Controller
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	PerfilRepository perfilRepository;
	
	@GetMapping("telaCadastro")
	public String cadastro(Model model) {
		return "cliente/cadastroCliente";
	}
	
	@PostMapping("cadastrar")
	public String cadastro(Cliente cliente) {
		cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
		Perfil perfil = perfilRepository.findByNome("ROLE_CLIENTE");
		cliente.setPerfis(Arrays.asList(perfil));
		clienteRepository.save(cliente);
		return "cliente/cadastroCliente";
	}
	
	@GetMapping("telaVisualizarCliente")
	public String visualizarClientes(Model model) {
		model.addAttribute("clientes", clienteRepository.findAll());
		return "cliente/visualizarCliente";
	}
	
}
