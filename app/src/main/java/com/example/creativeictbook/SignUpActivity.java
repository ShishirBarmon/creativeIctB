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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signUpEmailEditText,signUpPasswordEditText;
    private Button signUpButton;
    private TextView signInTextView;
    private ProgressBar signUpProgressBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sign_up );

        getSupportActionBar().hide();



        mAuth = FirebaseAuth.getInstance();


        signUpButton = findViewById( R.id.signUpButtonId );
        signUpEmailEditText = findViewById( R.id.signUpEmailId );
        signUpPasswordEditText  = findViewById( R.id.signUpPasswordId);
        signInTextView  = findViewById( R.id.signInTextViewId );
        signUpProgressBar = findViewById( R.id.signUpProgressBarId );

        signInTextView.setOnClickListener( this );
        signUpButton.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.signUpButtonId:
                userRegister();
                break;

            case R.id.signInTextViewId:
                Intent intent = new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity( intent );
                break;
        }
    }

    private  void userRegister() {

        String email = signUpEmailEditText.getText().toString().trim();
        String password = signUpPasswordEditText.getText().toString().trim();

        if(email.isEmpty())
        {
            signUpEmailEditText.setError( "Please Enter a Email" );
            signUpEmailEditText.requestFocus();
            return;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher( email ).matches())
        {
            signUpEmailEditText.setError( "Please enter a valid email" );
            signUpEmailEditText.requestFocus();
            return;
        }
        else if(password.isEmpty())
        {
            signUpPasswordEditText.setError( "Please enter a password" );
            signUpPasswordEditText.requestFocus();
            return;
        }
        else if (password.length()<6)
        {
            signUpPasswordEditText.setError( "Password should be more than 6 digits " );
            signUpPasswordEditText.requestFocus();
            return;
        }
        signUpProgressBar.setVisibility( View.VISIBLE );

        mAuth.createUserWithEmailAndPassword( email, password )
                .addOnCompleteListener( this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        signUpProgressBar.setVisibility( View.GONE );
                        if(task.isSuccessful())
                        {
                            finish();
                            Intent intent = new Intent( SignUpActivity.this, SuchiPatra.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity( intent );
                        }
                        else
                        {
                            if(task.getException()  instanceof FirebaseAuthUserCollisionException)
                            {
                                Toast.makeText( getApplicationContext(),"You are already registered",Toast.LENGTH_LONG ).show();
                            }
                            else {

                                Toast.makeText( getApplicationContext(),"Error :"+task.getException().getMessage(),Toast.LENGTH_LONG ).show();

                            }

                        }
                    }
                } );


    }

}
