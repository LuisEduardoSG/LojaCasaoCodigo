package com.example.android6928.lojacasadocodigo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.test.espresso.core.deps.guava.net.InternetDomainName;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android6928.lojacasadocodigo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by android6928 on 08/08/17.
 */

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener listener;

    @BindView(R.id.email_login)
    EditText txtEmail;
    @BindView(R.id.senha_login)
    EditText txtSenha;

    boolean usuarioLogado = false;

    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance();
        listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = auth.getCurrentUser();
                if(user!= null && !usuarioLogado){
                    usuarioLogado = true;
                    vaiParaMain();
                }
            }
        };
        auth.addAuthStateListener(listener);


    }

    private void vaiParaMain() {
        Intent intent = new Intent(this, ListaLivrosActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.logar_login)
    public void logar(){

        String email = this.txtEmail.getText().toString().trim();
        String senha = this.txtSenha.getText().toString().trim();

        if(!email.isEmpty() && (!senha.isEmpty())){
            auth.signInWithEmailAndPassword(email,senha)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(LoginActivity.this, "Acesso autorizado",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this, "Acesso não autorizado", Toast.LENGTH_SHORT ).show();
                            }

                        }
                    });

        }


    }

}
