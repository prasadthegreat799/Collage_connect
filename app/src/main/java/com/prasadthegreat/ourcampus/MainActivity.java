package com.prasadthegreat.ourcampus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mbottomNavigationView;
    FloatingActionButton mfloatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mbottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomNavView);
        mbottomNavigationView.setBackground(null);
        Menu menuNav=mbottomNavigationView.getMenu();
        MenuItem nav_item2 = menuNav.findItem(R.id.nothing);
        nav_item2.setEnabled(false);


        getSupportFragmentManager().beginTransaction().replace(R.id.container,new Home()).commit();
        mbottomNavigationView.setOnNavigationItemSelectedListener(bottomnavMethod);

        mfloatButton=(FloatingActionButton)findViewById(R.id.floatingActionButton);
        mfloatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new ourcommunity();
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            }
        });


    }

    private  BottomNavigationView.OnNavigationItemSelectedListener bottomnavMethod=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment fragment=null;
                    switch (item.getItemId()){

                        case R.id.home:
                            fragment=new Home();
                            break;
                        case R.id.placement:
                            fragment=new Placementcell();
                            break;
                        case R.id.examcell:
                            fragment=new Examcell();
                            break;
                        case R.id.profile:
                            fragment=new profile();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return true;
                }
            };
}