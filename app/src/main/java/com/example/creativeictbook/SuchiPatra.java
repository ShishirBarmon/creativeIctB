package com.example.creativeictbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

public class SuchiPatra extends AppCompatActivity {
    Button button1,button2,button3,button4,button5,button6;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_suchi_patra );

        button1 = (Button) findViewById( R.id.chapter1 );

        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SuchiPatra.this,chapter1.class );
                startActivity( intent );
            }
        } );


        button2 = (Button) findViewById( R.id.chapter2 );

        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SuchiPatra.this,chapter2.class );
                startActivity( intent );
            }
        } );


        button3 = (Button) findViewById( R.id.chapter3 );

        button3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SuchiPatra.this,chapter3.class );
                startActivity( intent );
            }
        } );


        button4 = (Button) findViewById( R.id.chapter4 );

        button4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SuchiPatra.this,chapter4.class );
                startActivity( intent );
            }
        } );


        button5 = (Button) findViewById( R.id.chapter5 );

        button5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SuchiPatra.this,chapter5.class );
                startActivity( intent );
            }
        } );


        button6 = (Button) findViewById( R.id.chapter6 );

        button6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SuchiPatra.this,chapter6.class );
                startActivity( intent );
            }
        } );






        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
 //       FloatingActionButton fab = findViewById( R.id.fab );
//        fab.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
//                        .setAction( "Action", null ).show();
//            }
//        } );
        DrawerLayout drawer = findViewById( R.id.drawer_layout );
        NavigationView navigationView = findViewById( R.id.nav_view );
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


        navigationView.getMenu().findItem(R.id.nav_contact).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText( getApplicationContext(),"pankoz01762361365@gmail.com",Toast.LENGTH_LONG ).show();
                return false;
            }
        });

        navigationView.getMenu().findItem(R.id.nav_help).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent( SuchiPatra.this,help.class );
                startActivity( intent );
                return false;
            }
        });

        navigationView.getMenu().findItem(R.id.nav_gallery).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent( SuchiPatra.this,video.class );
                startActivity( intent );
                return false;
            }
        });

        navigationView.getMenu().findItem(R.id.nav_upload).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent( SuchiPatra.this,notes.class );
                startActivity( intent );
                return false;
            }
        });

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_upload,
                R.id.nav_contact, R.id.nav_help )
                .setDrawerLayout( drawer )
                .build();
        NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment );
        NavigationUI.setupActionBarWithNavController( this, navController, mAppBarConfiguration );
        NavigationUI.setupWithNavController( navigationView, navController );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.suchi_patra, menu );
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment );
        return NavigationUI.navigateUp( navController, mAppBarConfiguration )
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();

        if(id ==R.id.action_about)
        {
            Toast.makeText( getApplicationContext(),"Education Life Line",Toast.LENGTH_LONG ).show();

            return true;
        }

        else   if(id ==R.id.action_contact)
        {
            Toast.makeText( getApplicationContext(),"pankoz01762361365@gmail.com",Toast.LENGTH_LONG ).show();
            return true;
        }

        else   if(id ==R.id.action_video)
        {

            Intent intent = new Intent( SuchiPatra.this,video.class );
            startActivity( intent );
            return true;
        }

        else   if(id ==R.id.action_notes)
        {
            Intent intent = new Intent( SuchiPatra.this,notes.class );
            startActivity( intent );
            return true;
        }


        else   if(id ==R.id.action_help)
        {
            Intent intent = new Intent( SuchiPatra.this,help.class );
            startActivity( intent );
            return true;
        }

        else   if(id ==R.id.action_comment)
        {
            Intent intent = new Intent( SuchiPatra.this,comment.class );
            startActivity( intent );
            return true;
        }
          else   if(id ==R.id.action_exit)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder( this );
            builder.setMessage( "Do you want to exit?" )
                    .setCancelable( false )
                    .setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            SuchiPatra.super.onBackPressed();
                        }
                    } )
                    .setNegativeButton( "No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    } );
            AlertDialog alertDialog = builder.create();
            alertDialog.show();


            return true;
        }
        else



            return super.onOptionsItemSelected( item );
    }
}
