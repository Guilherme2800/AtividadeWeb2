package br.com.ifpe.restaurante.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ifpe.restaurante.model.Cliente;
import br.com.ifpe.restaurante.model.FormaPagamento;
import br.com.ifpe.restaurante.model.Pedido;
import br.com.ifpe.restaurante.model.Prato;
import br.com.ifpe.restaurante.repository.FormaPagamentoRepository;
import br.com.ifpe.restaurante.repository.PedidoRepository;
import br.com.ifpe.restaurante.repository.PratoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PratoRepository pratoRepository;
	
	@Autowired
	FormaPagamentoRepository formaPagamentoRepository;
	
	@PostMapping("realizarPedido") 
	public String novoPedido(Model model, Pedido pedido, @RequestParam Long id) {
		
		Prato prato = pratoRepository.findById(id).get();
		Cliente cliente = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		pedido.setId(null);
		pedido.setPrato(prato);
		pedido.setCliente(cliente);
		pedido.setPreco(prato.getPreco());
		pedido.setDataHora(new Date());
		FormaPagamento formaPagamento = formaPagamentoRepository.findByDescricao(pedido.getFormaPagamento().getDescricao());
		pedido.setFormaPagamento(formaPagamento);
		
		pedidoRepository.save(pedido);
		
		return this.meusPedidos(model);
	}

	@GetMapping("realizarPedidoTela") 
	public String formulario(Model model, @RequestParam Long id) {
		
		model.addAttribute("prato", pratoRepository.findById(id).get());
		model.addAttribute("formasPagamento", formaPagamentoRepository.findAll());
		
		return "pedido/novoPedido";
	}
	
	@GetMapping("meusPedidos") 
	public String meusPedidos(Model model) {
		
		Cliente cliente = (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		model.addAttribute("pedidos", pedidoRepository.findByCliente_id(cliente.getId()));
		
		return "pedido/meusPedidos";
	}
	
	@GetMapping("todosPedidos")
	public String todosPedidos(Model model) {
		model.addAttribute("pedidos", pedidoRepository.findAll());
		return "pedido/todosPedidos";
	}
	
}
