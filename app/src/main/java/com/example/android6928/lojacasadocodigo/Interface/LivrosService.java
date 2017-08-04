package com.example.android6928.lojacasadocodigo.Interface;

import com.example.android6928.lojacasadocodigo.Modelo.Livro;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by android6928 on 01/08/17.
 */

public interface LivrosService {

    //@GET("listarLivros?indicePrimeiroLivro=0&qtdLivros=20")
    @GET("listarLivros")
    Call<List<Livro>> listarLivros(@Query("indicePrimeiroLivro") int primeiroLivro, @Query("qtdLivros") int ultimoLivro);


}
