package com.example.android6928.lojacasadocodigo;

import com.example.android6928.lojacasadocodigo.Modelo.Carrinho;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

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
        // db.getReference().child("carrinhos");                                                        //especifica o nó, se não existir ele criará;
        // db.getReference().child("carrinhos").child(auth.getCurrentUser().getUid());                  // peguei o usuário logado;
        db.getReference().child("carrinhos").child(auth.getCurrentUser().getUid()).setValue(carrinho);  // passa o objeto que queremos salvar.

    }


}
