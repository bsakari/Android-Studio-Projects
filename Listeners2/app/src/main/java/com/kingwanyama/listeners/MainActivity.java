package com.kingwanyama.listeners;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void create(View view) {
        Snackbar.make(view, "Sawa. Imeingiana", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void create(MenuItem item) {
        Toast.makeText(this, "Niambie Mbuyu", Toast.LENGTH_SHORT).show();
    }
}
