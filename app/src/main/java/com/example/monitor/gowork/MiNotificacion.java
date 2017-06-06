package com.example.monitor.gowork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/** Esta es la clase donde se escribe nuestra notificacion al ABRIRLA
 * El mensaje que recibimos se lee aqui
 *
 * **/

public class MiNotificacion extends AppCompatActivity {

    private TextView infoMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);

        infoMensaje = (TextView) findViewById(R.id.infoMensaje);

        if(getIntent().getExtras() != null) {

            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);
                infoMensaje.append("\n" + key + ": " + value);


            }

        }
    }

}
