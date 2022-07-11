package br.com.ifpe.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.restaurante.model.Prato;

public interface PratoRepository extends JpaRepository<Prato, Long>{

}
