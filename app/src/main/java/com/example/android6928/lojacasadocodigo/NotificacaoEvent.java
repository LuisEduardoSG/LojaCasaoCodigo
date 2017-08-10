package com.example.android6928.lojacasadocodigo;

import com.example.android6928.lojacasadocodigo.Modelo.Livro;
import com.google.firebase.messaging.RemoteMessage;

import java.util.List;

/**
 * Created by android6928 on 09/08/17.
 */
public class NotificacaoEvent {
    public RemoteMessage mensagem;

    public NotificacaoEvent(RemoteMessage message){
        this.mensagem = message;
    }

    public RemoteMessage getMessage(){
        return mensagem;
    }


}
