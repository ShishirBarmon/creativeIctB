package com.example.creativeictbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class help extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView1,textView2,textView3,textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_help );

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imageView = (ImageView) findViewById(R.id.helpImage);
        textView1 = (TextView) findViewById(R.id.helpName);
        textView2 = (TextView) findViewById(R.id.helpDesignation);
        textView3 = (TextView) findViewById(R.id.helpContact);
        textView4 = (TextView) findViewById(R.id.helpCollege);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent( help.this,SuchiPatra.class );
        startActivity( intent );
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id==android.R.id.home)
        {
            Intent intent = new Intent( help.this,SuchiPatra.class );
            startActivity( intent );
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
