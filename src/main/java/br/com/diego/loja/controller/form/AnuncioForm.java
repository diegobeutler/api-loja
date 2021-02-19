package br.com.diego.loja.controller.form;

import br.com.diego.loja.modelo.Anuncio;
import br.com.diego.loja.repository.AnuncioRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;


public class AnuncioForm {
    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String titulo;
    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String mensagem;

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String urlImagem;

    public AnuncioForm(String titulo, String mensagem, String urlImagem) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.urlImagem = urlImagem;
    }

    public Anuncio converter() {
        return new Anuncio(titulo, mensagem, urlImagem);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
    public Anuncio atualizar(Long id, AnuncioRepository anuncioRepository) {
        Anuncio anuncio = anuncioRepository.getOne(id);
        anuncio.setTitulo(this.titulo);
        anuncio.setMensagem(this.mensagem);
        anuncio.setUrlImagem(this.urlImagem);
        return anuncio;
    }


}
