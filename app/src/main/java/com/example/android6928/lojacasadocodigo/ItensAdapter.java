package com.example.android6928.lojacasadocodigo;

import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android6928.lojacasadocodigo.Activity.CarrinhoActivity;
import com.example.android6928.lojacasadocodigo.Interface.CarrinhoDelegate;
import com.example.android6928.lojacasadocodigo.Modelo.Carrinho;
import com.example.android6928.lojacasadocodigo.Modelo.Item;
import com.example.android6928.lojacasadocodigo.Modelo.Livro;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * Created by android6928 on 07/08/17.
 */
public class ItensAdapter extends RecyclerView.Adapter {

    private List<Item> itens;

    @Inject
    CarrinhoDelegate delegate;


    public ItensAdapter(List<Item> itens, CarrinhoActivity carrinhoActivity, CarrinhoDelegate delegate) {
        this.itens = itens;
        this.delegate = delegate;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layout = R.layout.item_carrinho;
        //instanciando a view,
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);

        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Holder holder = (Holder) viewHolder;
        //pega o item da lista livros
        Item item = itens.get(position);

        Picasso.with(holder.imagem.getContext())
                .load(item.getLivro().getUrlFoto())
                .placeholder(R.drawable.livro) //podemos colocar uma foto padrão caso aja problema
                .into(holder.imagem);

        holder.nomeLivro.setText(item.getLivro().getNome());


        //holder.valor.setText(item.getValor());

    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.imagem_item_comprado)
        ImageView imagem;


        @BindView(R.id.nome_item_comprado)
        TextView nomeLivro;

        @BindView(R.id.valor_pago_item_comprado)
        TextView valor;

        @BindView(R.id.botao_remove)
        Button btn;

        public Holder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.botao_remove)
        public void removeItem(){
            Item item = itens.get(getAdapterPosition());
            delegate.removeItem(item);
        }
    }


}
