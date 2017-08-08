package com.example.android6928.lojacasadocodigo.Interface;


import com.example.android6928.lojacasadocodigo.Activity.CarrinhoActivity;
import com.example.android6928.lojacasadocodigo.CasaDoCodigoModule;
import com.example.android6928.lojacasadocodigo.Fragment.DetalhesLivrosFragment;
import com.example.android6928.lojacasadocodigo.Modelo.Carrinho;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by android6928 on 07/08/17.
 */
@Singleton
@Component(modules = CasaDoCodigoModule.class)
public interface CasaDoCodigoComponent {

    void inject (CarrinhoActivity activity);
    void inject (DetalhesLivrosFragment fragment);
    Carrinho providesCarrinho();

}
