package com.example.android6928.lojacasadocodigo.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android6928.lojacasadocodigo.ListaLivrosAdapter;
import com.example.android6928.lojacasadocodigo.Modelo.Autor;
import com.example.android6928.lojacasadocodigo.Modelo.Livro;
import com.example.android6928.lojacasadocodigo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by android6928 on 31/07/17.
 */

public class ListaLivrosFragment extends Fragment {

    @BindView(R.id.list_livros_frag)
    protected RecyclerView listaLivrosView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, Bundle savedInstanceState){

        View view= inflater.inflate(R.layout.fragment_lista_livros,parent,false);


        ButterKnife.bind(this,view);

        List<Livro> livros = new ArrayList<>();

        //popular a lista de livros
        for (int i = 0; i<=5;i++) {
            Autor autor = new Autor();
            autor.setNome("Autor " + i);
            Livro livro = new Livro ("Livro " + i,"Descricao " + i, Arrays.asList(autor));
            livros.add(livro);
        }

        //retirado no ex 1.4 pag 17
        //this.listaLivrosView = (RecyclerView) view.findViewById(R.id.list_livros_frag);

        //passa para view, os dados.
        listaLivrosView.setAdapter(new ListaLivrosAdapter(livros));

        // obrigatório, sempre deve ser chamado quando Recycler ser utilizado
        listaLivrosView.setLayoutManager(new LinearLayoutManager(parent.getContext()));

        return view;
    }

}
