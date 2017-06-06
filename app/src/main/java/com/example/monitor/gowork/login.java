package com.example.monitor.gowork;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/** Ventana principal **/

public class login extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /** Lo de abajo es la fuente del TextView del login("Go Connect", en la primera activity**/

     String carpetaFuente = "fonts/Dogs.ttf";
        TextView vistaFuente = (TextView) findViewById(R.id.tvgoconnect);

     Typeface fuente = Typeface.createFromAsset(getAssets(),carpetaFuente);
        if (vistaFuente != null){
            vistaFuente.setTypeface(fuente);
        }
    }

    /** Log es el Intent para cambiar de ventana desde el login.java al wvloger.class **/
    public void log (View v) {
        Intent i = new Intent(this, wvloger.class );
        startActivity(i);
    }

    /** reg es el Intent para cambiar de ventana desde el login.java al registro.class **/
    public void reg (View v) {
        Intent i = new Intent(this, registro.class );
        startActivity(i);
    }



}
