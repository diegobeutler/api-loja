package br.com.diego.loja.controller.dto;

import br.com.diego.loja.modelo.Anuncio;
import br.com.diego.loja.modelo.Usuario;


import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AnuncioDto {

    private Long id;
    private String titulo;
    private String mensagem;
    private String urlImagem;
    private Usuario autor;
    private LocalDateTime data;

    public Usuario getAutor() {
        return autor;
    }

    public AnuncioDto(Anuncio anuncio){
        this.id = anuncio.getId();
        this.titulo = anuncio.getTitulo();
        this.mensagem = anuncio.getMensagem();
        this.urlImagem = anuncio.getUrlImagem();
        this.autor = anuncio.getAutor();
        this.data = anuncio.getData();
    }

    public static List<AnuncioDto> converter(List<Anuncio> anuncios) {
        return anuncios.stream().map(AnuncioDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getUrlImagem() {
        return urlImagem;
    }
}
