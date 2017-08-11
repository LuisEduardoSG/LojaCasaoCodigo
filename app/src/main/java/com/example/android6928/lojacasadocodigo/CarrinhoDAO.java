package com.example.android6928.lojacasadocodigo;

import android.util.Log;

import com.example.android6928.lojacasadocodigo.Activity.CarrinhoEvent;
import com.example.android6928.lojacasadocodigo.Modelo.Carrinho;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by android6928 on 09/08/17.
 */
public class CarrinhoDAO {

    private FirebaseDatabase db;
    private FirebaseAuth auth;

    public CarrinhoDAO(FirebaseDatabase db, FirebaseAuth auth) {
        this.db = db;
        this.auth = auth;
    }

    public void SalvarCarrinho(Carrinho carrinho){
        // db.getReference();                                                                           // no principal .. raíz
        // db.getReference().child("carrinhos");                                                        // especifica o nó, se não existir ele criará;
        // db.getReference().child("carrinhos").child(auth.getCurrentUser().getUid());                  // peguei o usuário logado;
        db.getReference().child("carrinhos").child(auth.getCurrentUser().getUid()).setValue(carrinho);  // passa o objeto que queremos salvar.

    }

    public void registraAtualizacoes(){
        db.getReference().child("carrinhos").child(auth.getCurrentUser().getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Carrinho carrinho = dataSnapshot.getValue(Carrinho.class);
                        EventBus.getDefault().post(new CarrinhoEvent(carrinho));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("CarrinhoDAO","Deu ruim!", databaseError.toException());
                    }
                });

    }


}
