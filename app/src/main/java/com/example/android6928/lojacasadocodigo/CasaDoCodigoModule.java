package com.example.android6928.lojacasadocodigo;




import com.example.android6928.lojacasadocodigo.Modelo.Carrinho;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;


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
    public Carrinho getCarrinho(){
        return new Carrinho();
    }
    @Singleton
    @Provides
    public FirebaseRemoteConfig getRemoteConfig(FirebaseRemoteConfigSettings settings ){
        FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        config.setDefaults(R.xml.remote_config);
        config.setConfigSettings(settings);
        return config;
    }
    @Singleton
    @Provides
    public FirebaseRemoteConfigSettings providesSettings(){
        FirebaseRemoteConfigSettings settings =
                new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(true)
                .build();
        return settings;
    }

    @Singleton
    @Provides
    public FirebaseDatabase providesDatabas(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //funciona offline
        database.setPersistenceEnabled(true);
        return database;
    }


    @Singleton
    @Provides
    public FirebaseAuth providesAuth(){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        //funciona offline
        return auth;
    }

    @Singleton
    @Provides
    public CarrinhoDAO providesCarrinhoDAO(FirebaseDatabase db, FirebaseAuth auth){
        return new CarrinhoDAO(db,auth);
    }

}
