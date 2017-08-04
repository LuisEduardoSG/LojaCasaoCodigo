package com.example.android6928.lojacasadocodigo;

import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by android6928 on 03/08/17.
 */

public abstract class EnlessListListener extends RecyclerView.OnScrollListener {

        int primeiroItemVisivel;
        int qtdItensVisivel;
        int qtdTotalItens;
        boolean carregando = true;
        int qtdTotalAnterior = 0;

    @Override
    public void onScrolled(RecyclerView recycler, int qtdHorizontal, int qtdVertical){
        LinearLayoutManager layout = (LinearLayoutManager) recycler.getLayoutManager();
        primeiroItemVisivel = layout.findFirstVisibleItemPosition();
        qtdItensVisivel = recycler.getChildCount();
        qtdTotalItens = layout.getItemCount();
        int indiceLimitePraCarregar = qtdTotalItens - qtdItensVisivel - 5;
        if (carregando){
            if(qtdTotalItens > qtdTotalAnterior){
                qtdTotalAnterior = qtdTotalItens;
                carregando= false;
            }
        }
        if (!carregando && primeiroItemVisivel >= indiceLimitePraCarregar){
            carregaMaisItens();
            carregando = true;
        }
    }

    protected abstract void carregaMaisItens();
}
