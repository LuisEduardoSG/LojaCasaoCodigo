package com.example.android6928.lojacasadocodigo;




import com.example.android6928.lojacasadocodigo.Modelo.Carrinho;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by android6928 on 07/08/17.
 */
@Module
public class CasaDoCodigoModule {
    @Singleton //
    @Provides
        //
    Carrinho providesCarrinho(){
        return new Carrinho();
    }

}
