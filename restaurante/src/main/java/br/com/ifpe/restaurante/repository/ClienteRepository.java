package br.com.ifpe.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.restaurante.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findByEmail(String username);

	Cliente findByCpf(Long cpf);
}
