package com.example.creativeictbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class video extends AppCompatActivity {

    private  WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_video );

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        webView = (WebView) findViewById(R.id.webViewId);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient( new WebViewClient());

        webView.loadUrl("https://www.youtube.com/watch?v=6nOavbvFvbY&list=PLgH5QX0i9K3o8Y-CKhmyodbfHAc9VSVOv\n");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent( video.this,SuchiPatra.class );
        startActivity( intent );
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id==android.R.id.home)
        {
            Intent intent = new Intent( video.this,SuchiPatra.class );
            startActivity( intent );
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
