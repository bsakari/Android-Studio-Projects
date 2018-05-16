package com.example.home.laviacollect;


import android.app.Fragment;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new Home()).commit();
            navigationView.setCheckedItem(R.id.home);
        }

    }

    @Override
    public boolean onNavigationItemSelected() {
        switch (item.getItemId()){
            case R.id.home:
                fragment = new Home();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new Home());
                break;
            case R.id.male:
                Fragment = new Male();

                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new Male());
                break;
            case R.id.female:
                Fragment = new Female();

                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new Female());
                break;
            case R.id.custom:
                Fragment = new Custom();

                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new Custom());
                break;
            case R.id.about:
                Fragment = new About();

                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new About());
                break;
            case R.id.sell:
                Fragment = new Sell();

                getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new Sell());
                break;
        }
        return true;
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();




        return true;
    }
}
