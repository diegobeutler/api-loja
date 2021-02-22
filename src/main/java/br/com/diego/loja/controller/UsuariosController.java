package br.com.diego.loja.controller;

import br.com.diego.loja.controller.dto.AnuncioDto;
import br.com.diego.loja.controller.dto.UsuarioDto;
import br.com.diego.loja.controller.form.UsuarioForm;
import br.com.diego.loja.modelo.Anuncio;
import br.com.diego.loja.modelo.Usuario;
import br.com.diego.loja.repository.UsuarioRepository;
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
@RequestMapping("/usuario")
public class UsuariosController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioDto> lista() {
        List<Usuario> usuarios;
        usuarios = usuarioRepository.findAll();
        return UsuarioDto.converter(usuarios);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm, UriComponentsBuilder uriBuilder) {
        Usuario usuario = usuarioForm.converter();
        usuarioRepository.save(usuario);
        URI uri = uriBuilder.path("/anuncios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<UsuarioDto> atualizar( @RequestBody @Valid UsuarioForm form) {

        Optional<Usuario> optional = usuarioRepository.findById(form.getId());
        if (optional.isPresent()) {
            Usuario usuario = form.atualizar(form.getId(), usuarioRepository);
            return ResponseEntity.ok(new UsuarioDto(usuario));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (optional.isPresent()) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> findById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(new UsuarioDto(usuario.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
