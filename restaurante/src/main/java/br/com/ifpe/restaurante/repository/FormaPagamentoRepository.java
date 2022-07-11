package br.com.ifpe.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.restaurante.model.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long>{

	FormaPagamento findByDescricao(String descricao);

}
