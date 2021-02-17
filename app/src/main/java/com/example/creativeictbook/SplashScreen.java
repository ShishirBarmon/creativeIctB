package com.example.creativeictbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    private ProgressBar splashProgressBar;
    private int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash_screen );

        getSupportActionBar().hide();
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );

        splashProgressBar = findViewById( R.id.SplashScreenProgressBarId );

        Thread thread = new Thread( new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        } );

        thread.start();
    }

    public void doWork()
    {
        for(progress=20; progress<=100; progress=progress+20){

            try {
                Thread.sleep( 1000 );
                splashProgressBar.setProgress(  progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void startApp()
    {
        Intent intent = new Intent(SplashScreen.this, SignInActivity.class);
        startActivity(intent);
        finish();
    }
}
