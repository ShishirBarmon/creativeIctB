package com.example.creativeictbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;

public class chapter5 extends AppCompatActivity {
    PDFView chapter5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_chapter5 );

        chapter5=(PDFView) findViewById( R.id.pdfView5 );
        chapter5.fromAsset( "pdf2.pdf" ).load();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent( chapter5.this,SuchiPatra.class );
        startActivity( intent );
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id==android.R.id.home)
        {
            Intent intent = new Intent( chapter5.this,SuchiPatra.class );
            startActivity( intent );
            finish();
        }


        return super.onOptionsItemSelected(item);
    }

}
