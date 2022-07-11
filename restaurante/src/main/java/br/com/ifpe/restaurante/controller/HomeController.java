package br.com.ifpe.restaurante.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.ifpe.restaurante.model.Cliente;
import br.com.ifpe.restaurante.model.OpcoesMenu;
import br.com.ifpe.restaurante.model.TipoPerfil;
import br.com.ifpe.restaurante.repository.PratoRepository;

@Controller
public class HomeController {

	@Autowired
	PratoRepository pratoRepository;
	
	@GetMapping("home")
	public String telaHome(Model model) {
		model.addAttribute("pratos", pratoRepository.findAll());
		
		Cliente cliente = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Set<OpcoesMenu> opcoesAutorizadas = new HashSet<>();
		
		for(GrantedAuthority perfil : cliente.getAuthorities()) {
			if(perfil.getAuthority().equals(TipoPerfil.ROLE_MODERADOR.toString())) {
				for(OpcoesMenu op : Arrays.asList(OpcoesMenu.values())) {
					opcoesAutorizadas.add(op);
				}
				break;
			}
			
			if(perfil.getAuthority().equals(TipoPerfil.ROLE_CLIENTE.toString())) {
				for(OpcoesMenu op : Arrays.asList(OpcoesMenu.values())) {
					if(op.getTipoAcesso().equals("ALL")) {
						opcoesAutorizadas.add(op);
					}
				}
			}
		}
		
		model.addAttribute("opcoes", opcoesAutorizadas);
		
		return "home/home";
	}
	
}
