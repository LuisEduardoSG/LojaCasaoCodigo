package com.example.android6928.lojacasadocodigo;




import com.example.android6928.lojacasadocodigo.Modelo.Carrinho;
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


}
