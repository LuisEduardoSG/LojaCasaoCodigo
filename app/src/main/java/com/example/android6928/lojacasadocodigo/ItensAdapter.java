package com.example.android6928.lojacasadocodigo;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.android6928.lojacasadocodigo.Activity.CarrinhoActivity;
import com.example.android6928.lojacasadocodigo.Modelo.Item;

import java.util.List;

/**
 * Created by android6928 on 07/08/17.
 */
public class ItensAdapter extends RecyclerView.Adapter {

    private List<Item> itens ;

    public ItensAdapter(List<Item> itens, CarrinhoActivity carrinhoActivity) {
        this.itens = itens;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
