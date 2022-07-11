package br.com.ifpe.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.restaurante.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByCliente_id(Long id);
	
}
