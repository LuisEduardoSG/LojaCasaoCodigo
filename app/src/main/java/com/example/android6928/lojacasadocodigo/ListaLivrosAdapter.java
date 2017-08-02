package com.example.android6928.lojacasadocodigo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android6928.lojacasadocodigo.Interface.LivrosDelegate;
import com.example.android6928.lojacasadocodigo.Modelo.Livro;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by android6928 on 31/07/17.
 */

public class ListaLivrosAdapter extends RecyclerView.Adapter {

    private List<Livro> livros;

    public ListaLivrosAdapter (List<Livro> livros){
        this.livros = livros;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = R.layout.item_livro_impar;
        if (viewType % 2 == 0) {
            layout = R.layout.item_livro_par;
        }
        //instanciando a view,
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);

        return new Holder(view);
    }

    @Override // setar os valores
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        Holder holder = (Holder) viewHolder;

        //pega o item da lista livros
        Livro livro = livros.get(position);

        //setando o título do livro
        holder.titulo.setText(livro.getNome());


    }


    @Override
    public int getItemCount() {
        return livros.size();
    }

    //Holder deve permanecer dentro da classe do Adapter
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


        @OnClick(R.id.item_livro)
        public void clickItem(){
            Livro livro = livros.get(getAdapterPosition());
            LivrosDelegate delegate = (LivrosDelegate)  itemView.getContext();
            delegate.lidaComLivroSelecionado(livro);


        }

    }

}
