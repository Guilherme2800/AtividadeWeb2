package br.com.ifpe.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifpe.restaurante.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long>{

	Perfil findByNome(String string);

}
