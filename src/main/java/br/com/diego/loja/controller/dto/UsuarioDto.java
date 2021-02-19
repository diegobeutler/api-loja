package br.com.diego.loja.controller.dto;

import br.com.diego.loja.modelo.Anuncio;
import br.com.diego.loja.modelo.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDto {
    private Long id;
    private String nome;
    private String email;
    private String senha;


    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public static List<br.com.diego.loja.controller.dto.UsuarioDto> converter(List<Usuario> usuarios) {
        return usuarios.stream().map(br.com.diego.loja.controller.dto.UsuarioDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
