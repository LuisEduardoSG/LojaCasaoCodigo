package com.example.android6928.lojacasadocodigo.Interface;

import com.example.android6928.lojacasadocodigo.Modelo.Livro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by android6928 on 01/08/17.
 */

public interface LivrosService {

    //
    @GET("listaLivros")
    Call<List<Livro>> ListarLivros();
}
