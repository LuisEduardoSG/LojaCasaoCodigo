package com.example.android6928.lojacasadocodigo.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.android6928.lojacasadocodigo.CasaDoCodigoApplication;
import com.example.android6928.lojacasadocodigo.Fragment.DetalhesLivrosFragment;
import com.example.android6928.lojacasadocodigo.Interface.CasaDoCodigoComponent;
import com.example.android6928.lojacasadocodigo.Modelo.Carrinho;
import com.example.android6928.lojacasadocodigo.ItensAdapter;
import com.example.android6928.lojacasadocodigo.Modelo.Item;
import com.example.android6928.lojacasadocodigo.R;

import java.util.List;

import javax.inject.Inject;

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


    @Inject
    Carrinho carrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        ButterKnife.bind(this);


        //assim o inject funciona
        /*CasaDoCodigoComponent component = ((CasaDoCodigoApplication) getApplication()).getComponent();
        component.inject(this);
*/

        CasaDoCodigoApplication app = (CasaDoCodigoApplication) getApplication();
        app.getComponent().inject(this);

        //opcional
   /*     this.carrinho = component.providesCarrinho();


        List<Item>itens = carrinho.getItens();
        this.listaItens.setAdapter(new ItensAdapter(itens, this));
        this.listaItens.setLayoutManager(new LinearLayoutManager(this));
*/

    }
    
    
    
    @Override
    protected void onResume(){
        super.onResume();
        carregaLista();
    }

    private void carregaLista() {
        this.listaItens.setAdapter(new ItensAdapter(carrinho.getItens(), this));
        this.listaItens.setLayoutManager(new LinearLayoutManager(this));

        double total = 0;

        for (Item item : carrinho.getItens()){
            total += item.getValor();
        }
        valorTotal.setText("R$ " + total);
    }
}
