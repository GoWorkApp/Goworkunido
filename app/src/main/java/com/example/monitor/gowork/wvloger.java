package com.example.monitor.gowork;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/** ESTE ES EL WEBVIEW DE LA PAGINA DE GOWORK DONDE HACEMOS LOGIN **/
public class wvloger extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wvloger);

        final WebView mWebView = (WebView) findViewById(R.id.wview);
        mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
       // mWebView.setWebViewClient(new SSLTolerentWebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setDatabaseEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setBuiltInZoomControls(true);

        mWebView.loadUrl("https://gowork.es/site/login");




            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.getSettings().setUseWideViewPort(true);

            mWebView.setWebViewClient(new WebViewClient() {

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);

                    String redirected = view.getUrl();
                    redirected= Uri.decode(redirected);

                    if (redirected.equals ("https://gowork.es/site/profile")) {
                        mWebView.stopLoading();
//en login.class va la ventana Mapas
                        Intent mIntent = new Intent(wvloger.this, MapsActivity .class);
                        startActivity(mIntent);
                    }
                }

                @Override
                public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                    super.onReceivedHttpError(view, request, errorResponse);
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    return super.shouldOverrideUrlLoading(view, request);
                }
            });

        };
    }
