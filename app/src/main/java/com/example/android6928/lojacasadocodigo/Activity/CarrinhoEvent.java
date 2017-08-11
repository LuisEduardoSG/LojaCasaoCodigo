package com.example.android6928.lojacasadocodigo.Activity;

import com.example.android6928.lojacasadocodigo.Modelo.Carrinho;

import javax.inject.Inject;

/**
 * Created by android6928 on 10/08/17.
 */
public class CarrinhoEvent {

    @Inject
    public Carrinho carrinho;

    public CarrinhoEvent(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
}
