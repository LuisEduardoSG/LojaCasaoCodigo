package com.example.android6928.lojacasadocodigo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android6928.lojacasadocodigo.Modelo.Livro;

import java.util.List;

/**
 * Created by android6928 on 03/08/17.
 */

public class ItemAdapter extends RecyclerView.Adapter {


    private List<Livro> livros;

    public void ItemAdapter(){

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_carrinho,parent,false);

        return
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
