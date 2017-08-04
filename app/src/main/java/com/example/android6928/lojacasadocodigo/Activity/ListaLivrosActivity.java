package com.example.android6928.lojacasadocodigo.Activity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android6928.lojacasadocodigo.Fragment.DetalhesLivrosFragment;
import com.example.android6928.lojacasadocodigo.Fragment.ListaLivrosFragment;
import com.example.android6928.lojacasadocodigo.Interface.LivrosDelegate;
import com.example.android6928.lojacasadocodigo.LivrosEvent;
import com.example.android6928.lojacasadocodigo.Modelo.Livro;
import com.example.android6928.lojacasadocodigo.R;
import com.example.android6928.lojacasadocodigo.WebClient;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class ListaLivrosActivity extends AppCompatActivity implements LivrosDelegate {

    private ListaLivrosFragment listaLivrosFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_livros);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        listaLivrosFragment = new ListaLivrosFragment();
        transaction.replace(R.id.frame_livros, listaLivrosFragment);
        transaction.commit();

        new WebClient().getLivros(0,10);


        EventBus.getDefault().register(this);


        /*
        RecyclerView listaLivrosView = (RecyclerView) findViewById(R.id.list_livros);
        List<Livro> livros = new ArrayList<>();

        //popular a lista de livros
        for (int i = 0; i<=5;) {

        }

        //passa para view, os dados.
        listaLivrosView.setAdapter(new ListaLivrosAdapter(livros));

        // obrigatório, sempre deve ser chamado quando Recycler ser utilizado
        listaLivrosView.setLayoutManager(new LinearLayoutManager(this));*/
    }

    public void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    //pega o livro da lista e carrega o detalhes
    @Override
    public void lidaComLivroSelecionado(Livro livro) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        DetalhesLivrosFragment detalhesFrag = new DetalhesLivrosFragment();
        Bundle b = new Bundle();

        b.putSerializable("livro", livro);

        detalhesFrag.setArguments(b);

        transaction.replace(R.id.frame_livros, detalhesFrag);
        //impede de dar um finish(); na activity pai
        transaction.addToBackStack(null);

        transaction.commit();
    }

    @Subscribe
    public void lidaComSucesso(LivrosEvent evento/*List<Livro> livros*/) {
        List<Livro> livros = evento.getLivros();
        listaLivrosFragment.populaLista(livros);
        //listaLivrosFragment.populaLista(livros);
    }

    @Subscribe
    public void lidaComErro(Throwable t) {
        Toast.makeText(this, "Não foi possível carregar os Livros - Erro " + t,Toast.LENGTH_SHORT).show();
    }

  /*
    @Subscribe
    public void recebeLivros(LivrosEvent evento){

    }

    @Subscribe
    public void recebeErro(Throwable erro){
        Toast.makeText(this, "Não deu pra carregar, mals ae.", Toast.LENGTH_SHORT).show();
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_lista_livros_avtivity);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.vai_para_carrinho){
            Intent vaiCarrinho = new Intent(this, CarrinhoActivity.class);
            startActivity(vaiCarrinho);
        }
    }


}
