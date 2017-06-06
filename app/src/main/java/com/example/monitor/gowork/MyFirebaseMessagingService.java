package com.example.monitor.gowork;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/** TODO LO QUE SE MUESTRA AL RECIBIR LA NOTIFICACION DE LA BASE DE DATOS **/

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public static final String TAG = "NOTICIAS";
    private String body;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        Log.d(TAG, "Mensaje recibido de:" + from );

        if (remoteMessage.getNotification() != null){
            Log.d(TAG, "Notificacion: " + remoteMessage.getNotification().getBody());

            mostrarNotificacion(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
            body=remoteMessage.getNotification().getBody();
        }

        if (remoteMessage.getData().size() > 0){
            Log.d(TAG, "Data: "+ remoteMessage.getData());


        }
    }
    /** El INTENT para pasar de la notificacion de la barra de arriba al layout donde sale el mensaje completo **/
    private void mostrarNotificacion(String title, String body) {

        Intent intent = new Intent(this, MiNotificacion.class);
        intent.putExtra(title, body);

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        /** Muestra la notificacion emergente y el sonido/icono al recibirla **/
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_event)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());



    }
}
