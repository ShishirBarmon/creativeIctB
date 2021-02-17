package com.example.creativeictbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signInEmailEditText,signInPasswordEditText;
    private Button signInButton;
    private TextView signUpTextView;
    private ProgressBar signInprogressBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sign_in );

        getSupportActionBar().hide();


        mAuth = FirebaseAuth.getInstance();


        signInButton = findViewById( R.id.signInButtonId );
        signInEmailEditText = findViewById( R.id.signInEmailId );
        signInPasswordEditText = findViewById( R.id.signInPasswordId );
        signUpTextView = findViewById( R.id.signUpTextViewId );
        signInprogressBar= findViewById( R.id.signInProgressBarId );

        signUpTextView.setOnClickListener( this );
        signInButton.setOnClickListener( this );


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.signInButtonId:
                userlogin();
                break;

            case R.id.signUpTextViewId:

                Intent intent = new Intent( SignInActivity.this, SignUpActivity.class );
                startActivity( intent );
                break;
        }
    }



    private void userlogin() {
        String email = signInEmailEditText.getText().toString().trim();
        String password = signInPasswordEditText.getText().toString().trim();

        if(email.isEmpty())
        {
            signInEmailEditText.setError( "Please enter a Email" );
            signInEmailEditText.requestFocus();
            return;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher( email ).matches())
        {
            signInEmailEditText.setError( "Please enter a valid email" );
            signInEmailEditText.requestFocus();
            return;
        }
        else if(password.isEmpty())
        {
            signInPasswordEditText.setError( "Please enter a Password" );
            signInPasswordEditText.requestFocus();
            return;
        }
        else if(password.length()<6) {
            signInPasswordEditText.setError( "password should be minimum 6 digits" );
            signInPasswordEditText.requestFocus();
            return;
        }

        signInprogressBar.setVisibility( View.VISIBLE );

        mAuth.signInWithEmailAndPassword( email,password )
                .addOnCompleteListener( this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        signInprogressBar.setVisibility( View.GONE );
                        if(task.isSuccessful())
                        {
                            finish();
                            Intent intent = new Intent( SignInActivity.this, SuchiPatra.class );
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity( intent );
                        }
                        else
                        {
                            Toast.makeText( getApplicationContext(),"Register is not Successful",Toast.LENGTH_LONG ).show();
                        }
                    }
                } );
    }

}
