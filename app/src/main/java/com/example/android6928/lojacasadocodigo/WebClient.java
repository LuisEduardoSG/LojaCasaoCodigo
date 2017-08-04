package com.example.android6928.lojacasadocodigo;

import android.app.usage.UsageEvents;
import android.support.annotation.NonNull;

import com.example.android6928.lojacasadocodigo.Converter.LivroServiceConverterFactory;
import com.example.android6928.lojacasadocodigo.Interface.LivrosDelegate;
import com.example.android6928.lojacasadocodigo.Interface.LivrosService;
import com.example.android6928.lojacasadocodigo.Modelo.Livro;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by android6928 on 01/08/17.
 */

public class WebClient {
    private static final String URL_BASE = "http://cdcmob.herokuapp.com/";
   //Ex 3.6
    /* private final LivrosDelegate delegate;

    public WebClient(LivrosDelegate  delegate){
        this.delegate = delegate;
    }
*/


    public void getLivros(int primeiro,int qtdLivros){
        Retrofit client = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(new LivroServiceConverterFactory())
                .build();
        LivrosService service = client.create(LivrosService.class);

        Call<List<Livro>> caller = service.listarLivros(primeiro, qtdLivros);

        caller.enqueue(new Callback<List<Livro>>(){
            @Override
            public void onResponse( Call<List<Livro>> call,  Response<List<Livro>> resposta){
                //delegate.lidaComSucesso(resposta.body());
                EventBus.getDefault().post(new LivrosEvent(resposta.body()));

            }
            @Override
            public void onFailure( Call<List<Livro>> call,  Throwable t ){
                //delegate.lidaComErro(t);
                EventBus.getDefault().post(t);

            }

        });
    }

}
