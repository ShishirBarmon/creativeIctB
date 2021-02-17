package com.example.creativeictbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class comment extends AppCompatActivity implements View.OnClickListener {

    private Button sendButton,clearButton;
    private EditText nameEditText,commentEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_comment );

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        sendButton = (Button) findViewById(R.id.sendButtonId);
        clearButton = (Button) findViewById(R.id.clearButtonId);


        nameEditText = (EditText) findViewById(R.id.nameEditTextId);
        commentEditText = (EditText) findViewById(R.id.commentEditTextId);

        sendButton.setOnClickListener( this);
        clearButton.setOnClickListener( this);
    }

    public void onClick(View v){
        try {
            String name = nameEditText.getText().toString();
            String comment = commentEditText.getText().toString();

            if(v.getId()==R.id.sendButtonId)
            {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String []{"pankoz01762361365@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Comment from App");
                intent.putExtra(Intent.EXTRA_TEXT,"Name : "+name + "\n Comment: " + comment);
                startActivity(Intent.createChooser(intent,"Connect with"));
            }
            else if(v.getId()==R.id.clearButtonId)
            {
                nameEditText.setText("");
                commentEditText.setText("");
            }


        } catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Exception : "+e,Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent( comment.this,SuchiPatra.class );
        startActivity( intent );
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id==android.R.id.home)
        {
            Intent intent = new Intent( comment.this,SuchiPatra.class );
            startActivity( intent );
            finish();
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
