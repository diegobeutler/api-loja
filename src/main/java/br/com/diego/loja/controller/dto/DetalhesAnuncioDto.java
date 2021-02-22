package br.com.diego.loja.controller.dto;

import br.com.diego.loja.modelo.Anuncio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesAnuncioDto {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data;
    private String nomeAutor;
    private List<ComentarioDto> comentarios;

    public DetalhesAnuncioDto(Anuncio anuncio){
        this.id = anuncio.getId();
        this.titulo = anuncio.getTitulo();
        this.mensagem = anuncio.getMensagem();
        this.data = anuncio.getData();
        this.nomeAutor = anuncio.getAutor().getNome();
        this.comentarios = new ArrayList<>();
        this.comentarios.addAll(anuncio.getComentario().stream().map(ComentarioDto::new).collect(Collectors.toList()));
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

    public String getNomeAutor() {
        return nomeAutor;
    }

    public List<ComentarioDto> getComentarios() {
        return comentarios;
    }
}
