package com.example.android6928.lojacasadocodigo;

import android.app.Application;

import com.example.android6928.lojacasadocodigo.Interface.CasaDoCodigoComponent;
import com.example.android6928.lojacasadocodigo.Interface.DaggerCasaDoCodigoComponent;

/**
 * Created by android6928 on 07/08/17.
 */

public class CasaDoCodigoApplication extends Application {
    private CasaDoCodigoComponent component;
    @Override
    public void onCreate(){
        super.onCreate();
       component = DaggerCasaDoCodigoComponent.builder().build();
    }
    public CasaDoCodigoComponent getComponent(){
        return this.component;
    }

}
