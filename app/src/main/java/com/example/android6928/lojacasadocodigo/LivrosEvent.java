package com.example.android6928.lojacasadocodigo;

import com.example.android6928.lojacasadocodigo.Modelo.Livro;

import java.util.List;

/**
 * Created by android6928 on 02/08/17.
 */

public class LivrosEvent {
    public List<Livro> livros;

    public LivrosEvent(List<Livro> livro){
        this.livros = livro;
    }

    public List<Livro> getLivros(){
        return livros;
    }
}

