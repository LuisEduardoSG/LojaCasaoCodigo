package com.example.android6928.lojacasadocodigo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by android6928 on 31/07/17.
 */

public class Holder extends RecyclerView.ViewHolder {

    ImageView foto;
    TextView titulo;

    public Holder(View itemView) {
        super(itemView);
        this.foto = (ImageView) itemView.findViewById(R.id.item_foto);
        this.titulo = (TextView) itemView.findViewById(R.id.item_nome);


    }


}
