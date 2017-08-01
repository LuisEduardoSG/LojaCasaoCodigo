package com.example.android6928.lojacasadocodigo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by android6928 on 31/07/17.
 */

public class Holder extends RecyclerView.ViewHolder {
    @BindView(R.id.item_foto)
    ImageView foto;

    @BindView(R.id.item_nome)
    TextView titulo;

    public Holder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        //retirado ex 1.4 pag 17
     /* this.foto = (ImageView) itemView.findViewById(R.id.item_foto);
        this.titulo = (TextView) itemView.findViewById(R.id.item_nome);*/


    }


}
