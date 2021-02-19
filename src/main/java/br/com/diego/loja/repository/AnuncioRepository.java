package br.com.diego.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.diego.loja.modelo.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

	List<Anuncio> findByTitulo(String titulo);

    List<Anuncio> findByAutor_Nome(String userName);
}
