package com.example.creativeictbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class notes extends AppCompatActivity {

    private WebView notesWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_notes );

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        notesWebView = (WebView) findViewById(R.id.notesWebViewId);


        WebSettings webSettings = notesWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        notesWebView.setWebViewClient( new WebViewClient());

        notesWebView.loadUrl("https://drive.google.com/drive/u/0/folders/1Yp-fcgNhxbNOlRA7gpxbvnIYkHpq80Rd\n");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent( notes.this,SuchiPatra.class );
        startActivity( intent );
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id==android.R.id.home)
        {
            Intent intent = new Intent( notes.this,SuchiPatra.class );
            startActivity( intent );
            finish();
        }


        return super.onOptionsItemSelected(item);
    }



}
