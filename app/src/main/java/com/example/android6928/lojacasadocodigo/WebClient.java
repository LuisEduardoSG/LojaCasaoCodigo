package com.example.android6928.lojacasadocodigo;

import com.example.android6928.lojacasadocodigo.Interface.LivrosDelegate;
import com.example.android6928.lojacasadocodigo.Interface.LivrosService;
import com.example.android6928.lojacasadocodigo.Modelo.Livro;

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
    private LivrosDelegate delegate;


    public WebClient(LivrosDelegate delegate)
    {
        this.delegate = delegate;
    }



    public void getLivros(){
        Retrofit client = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(new LivroConvertFactory())
                .build();
        LivrosService service = client.create(LivrosService.class);

        service.enqueue(new Callback<List<Livro>>(){
            public void onResponse(Call<List<Livro>> call, Response<List<Livro>> resposta){
                delegate.lidaComSucesso(resposta.body());

            }

            public void onFailure(Call<List<Livro>> call, Throwable t ){
                delegate.lidaComErro(t);
            }

        });
    }

}
