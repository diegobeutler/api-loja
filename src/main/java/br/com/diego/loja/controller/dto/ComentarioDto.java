package br.com.diego.loja.controller.dto;

import java.time.LocalDateTime;

import br.com.diego.loja.modelo.Comentario;

public class ComentarioDto {
    private Long id;
    private String mensagem;
    private LocalDateTime data;
    private String nomeAutor;

    public ComentarioDto(Comentario comentario){
        this.id = comentario.getId();
        this.mensagem = comentario.getMensagem();
        this.data = comentario.getData();
        this.nomeAutor = comentario.getAutor().getNome();
    }
    
    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public LocalDateTime getData() {
        return data;
    }

}
