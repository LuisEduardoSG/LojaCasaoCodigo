package com.example.android6928.lojacasadocodigo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.android6928.lojacasadocodigo.Activity.ListaLivrosActivity;
import com.example.android6928.lojacasadocodigo.NotificacaoEvent;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by android6928 on 09/08/17.
 */

public class NotificationService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage message){
        EventBus.getDefault().post(new NotificacaoEvent(message));

        Intent intent = new Intent(getBaseContext(), ListaLivrosActivity.class);
        //serve tbm para definir o comportamento da notifcação
        PendingIntent pendint = PendingIntent.getActivity(getBaseContext(),123,intent,PendingIntent.FLAG_CANCEL_CURRENT);

        String textoMensagem = message.getNotification().getBody();
        Notification notification = new NotificationCompat.Builder(getBaseContext())
                .setContentTitle(textoMensagem)
                //.addAction()
                .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                .setAutoCancel(true)
                .setContentIntent(pendint).build();

        NotificationManager manger = (NotificationManager) getBaseContext().getSystemService(NOTIFICATION_SERVICE);
        manger.notify(123,notification);

    }
}
