package br.com.diego.loja.controller;

import br.com.diego.loja.controller.dto.AnuncioDto;
import br.com.diego.loja.controller.dto.DetalhesAnuncioDto;
import br.com.diego.loja.controller.form.AnuncioForm;
import br.com.diego.loja.controller.form.AtualizacaoAnuncioForm;
import br.com.diego.loja.modelo.Anuncio;
import br.com.diego.loja.repository.AnuncioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anuncios")
public class AnunciosController {
    @Autowired
    private AnuncioRepository anuncioRepository;

    @GetMapping
    public List<AnuncioDto> lista(String titulo) {
        List<Anuncio> anuncios;
        if (titulo == null) {
            anuncios = anuncioRepository.findAll();
        } else {
            anuncios = anuncioRepository.findByTitulo(titulo);
        }
        return AnuncioDto.converter(anuncios);
    }

    @GetMapping("/user/{userName}")
    public List<AnuncioDto> listaPorUsuario(@PathVariable String userName) {
        List<Anuncio> anuncios;
        anuncios = anuncioRepository.findByAutor_Nome(userName);
        return AnuncioDto.converter(anuncios);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AnuncioDto> cadastrar(@RequestBody @Valid AnuncioForm anuncioForm, UriComponentsBuilder uriBuilder) {
        Anuncio anuncio = anuncioForm.converter();
        anuncioRepository.save(anuncio);
        URI uri = uriBuilder.path("/anuncios/{id}").buildAndExpand(anuncio.getId()).toUri();
        return ResponseEntity.created(uri).body(new AnuncioDto(anuncio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnuncioDto> findById(@PathVariable Long id) {
        Optional<Anuncio> anuncio = anuncioRepository.findById(id);
        if (anuncio.isPresent()) {
            return ResponseEntity.ok(new AnuncioDto(anuncio.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AnuncioDto> atualizar(@PathVariable Long id, @RequestBody @Valid AnuncioForm form) {

        Optional<Anuncio> optional = anuncioRepository.findById(id);
        if (optional.isPresent()) {
            Anuncio anuncio = form.atualizar(id,anuncioRepository);
            return ResponseEntity.ok(new AnuncioDto(anuncio));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Anuncio> optional = anuncioRepository.findById(id);
        if (optional.isPresent()) {
            anuncioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
