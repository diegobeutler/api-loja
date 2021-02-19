package br.com.diego.loja.controller.form;

import br.com.diego.loja.modelo.Anuncio;
import br.com.diego.loja.repository.AnuncioRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoAnuncioForm {
    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String titulo;
    @NotNull @NotEmpty@org.hibernate.validator.constraints.Length(min = 10)
    private String mensagem;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Anuncio atualizar(Long id, AnuncioRepository anuncioRepository) {
        Anuncio anuncio = anuncioRepository.getOne(id);
        anuncio.setTitulo(this.titulo);
        anuncio.setMensagem(this.mensagem);
        return anuncio;
    }
}
