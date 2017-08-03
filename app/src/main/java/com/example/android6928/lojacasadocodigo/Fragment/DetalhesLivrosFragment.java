package com.example.android6928.lojacasadocodigo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android6928.lojacasadocodigo.Modelo.Autor;
import com.example.android6928.lojacasadocodigo.Modelo.Livro;
import com.example.android6928.lojacasadocodigo.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by android6928 on 01/08/17.
 */

public class DetalhesLivrosFragment extends Fragment {

    @BindView(R.id.detalhes_livro_foto)
    ImageView foto;

    @BindView(R.id.detalhes_livro_nome)
    TextView nome;

    @BindView(R.id.detalhes_livro_autores)
    TextView autores;

    @BindView(R.id.detalhes_livro_descricao)
    TextView descricao;

    @BindView(R.id.detalhes_livro_num_paginas)
    TextView numPag;

    @BindView(R.id.detalhes_livro_isbn)
    TextView isbn;

    @BindView(R.id.detalhes_livro_data_publicacao)
    TextView dataPublic;

    @BindView(R.id.detalhes_livro_comprar_fisico)
    Button botaoComprarFisico;

    @BindView(R.id.detalhes_livro_comprar_ebook)
    Button botaoComprarEbook;

    @BindView(R.id.detalhes_livro_comprar_ambos)
    Button botaoComprarAmbos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalhes_livro, container, false);
        ButterKnife.bind(this, view);

        if (getArguments() != null) {
            Bundle arguments = getArguments();
            Livro livro = (Livro) arguments.getSerializable("livro");
            populaCamposCom(livro);
        }
        return view;
    }


    private void populaCamposCom(Livro livro){
        nome.setText(livro.getNome());
        String listaDeAutores = "";
        for (Autor autor : livro.getAutores()){
            if (!listaDeAutores.isEmpty()){
                listaDeAutores += ", ";
            }
            listaDeAutores += autor.getNome();
        }

        Picasso.with(getContext())
                .load(livro.getUrlFoto())
                .placeholder(R.drawable.livro)
                .into(foto);

        autores.setText(listaDeAutores);

        descricao.setText(livro.getDescricao());

        numPag.setText(String.valueOf(livro.getNumPag()));

        isbn.setText(livro.getISBN());

        dataPublic.setText(livro.getDataPublicacao());

        String textoComprarFisico = String.format("Comprar Livro Físico - R$ %.2f",livro.getValorFisico());
        botaoComprarFisico.setText(textoComprarFisico);

        String textoComprarEbook = String.format("Comprar E-book - R$ %.2f",livro.getValorVirtual());
        botaoComprarEbook.setText(textoComprarEbook);

        String textoComprarAmbos = String.format("Comprar Ambos - R$ %.2f",livro.getValorDoisJuntos());
        botaoComprarAmbos.setText(textoComprarAmbos);


    }

}
