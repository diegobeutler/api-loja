package br.com.diego.loja.controller.form;
import br.com.diego.loja.modelo.Usuario;

import br.com.diego.loja.repository.UsuarioRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioForm {
    private Long id;
    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String nome;
    @NotNull
    @NotEmpty
    @Length(min = 3)
    @Email
    private String email;
    @NotNull
    @NotEmpty
    @Length(min = 6)
    private String senha;


    public UsuarioForm(Long id, @NotNull @NotEmpty @Length(min = 3) String nome, @NotNull @NotEmpty @Length(min = 3) @Email String email, @NotNull @NotEmpty @Length(min = 6) String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario converter() {
        return new Usuario(id, nome, email, senha);
    }

    public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.getOne(id);
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        return usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
