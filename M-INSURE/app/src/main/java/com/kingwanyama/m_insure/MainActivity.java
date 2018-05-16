package com.kingwanyama.m_insure;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView companies;
    String [] items = {"NASA",
                        "TIBIM",
                        "THE",
                        "LORD",
                        "IS",
                        "MY",
                        "SHEPHERED",
                        "I SHALL",
                        "NOT",
                        "WANT",
            "NASA",
            "TIBIM",
            "THE",
            "LORD",
            "IS",
            "MY",
            "SHEPHERED",
            "I SHALL",
            "NOT",
            "WANT","AMEN"};
    ArrayAdapter<String> myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //LOGIC: POPULATE THE LIST VIEW WITH REAL DATA


        companies = (ListView) findViewById(R.id.companies);

        //ADD THE ITEMS TO YOUR LIST VIEW
        //TO COMBINE THE LIST VIEW AND THE ITEMS,YOU NEED AN ADAPTER
        //PASS THREE PARAMITERS> CLASS, DESIGN, ITEMS
        //myadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        myadapter = new ArrayAdapter<String>(this,R.layout.design,items);
        companies.setAdapter(myadapter);
        
        //ADD LISTENERS
        companies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //CREATE A NEW EMPTY ACTIVITY


                Intent x = new Intent(getApplicationContext(),InfoActivity.class);

                //WE NEED PASS POSITION TO  infoActivity

                Bundle b = new Bundle(); //Will carry position
                b.putInt("key",position);

                //put the bundle to the intent

                x.putExtras(b);

                startActivity(x);




            }
        });



















        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent x = new Intent(MainActivity.this,ArroundMe.class);
                startActivity(x);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
