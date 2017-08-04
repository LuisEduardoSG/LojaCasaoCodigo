package com.example.android6928.lojacasadocodigo.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.android6928.lojacasadocodigo.Carrinho;
import com.example.android6928.lojacasadocodigo.ItemAdapter;
import com.example.android6928.lojacasadocodigo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by android6928 on 03/08/17.
 */

public class CarrinhoActivity extends AppCompatActivity {

    @BindView(R.id.list_itens)
    RecyclerView listaItens;

    @BindView(R.id.valor_carrinho)
    TextView valorTotal;

    private Carrinho carrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        ButterKnife.bind(this);

        this.carrinho = new Carrinho();

        this.listaItens.setAdapter(new ItensAdapter(carrinho.getItens()));
        this.listaItens.setLayoutManager(new LinearLayoutManager(this));

    }
    
    
    
    @Override
    protected void onResume(){
        super.onResume();
        carregaLista();
    }

    private void carregaLista() {
    }
}
