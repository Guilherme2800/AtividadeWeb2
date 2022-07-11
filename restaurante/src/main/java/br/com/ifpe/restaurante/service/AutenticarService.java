package br.com.ifpe.restaurante.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ifpe.restaurante.model.Cliente;
import br.com.ifpe.restaurante.repository.ClienteRepository;

@Service
public class AutenticarService implements UserDetailsService{

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Cliente> clienteOpt = Optional.of(clienteRepository.findByEmail(username));
		if(clienteOpt.isPresent()) {
			return clienteOpt.get();
		}
		throw new UsernameNotFoundException("Dados invalidos");
	}

}
