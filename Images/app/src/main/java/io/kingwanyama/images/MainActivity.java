package io.kingwanyama.images;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void imageOne(View view) {
        //Tast
        Toast.makeText(this, "Image One Clicked", Toast.LENGTH_SHORT).show();
    }

    public void imageTwo(View view) {
        Toast.makeText(this, "Image Two Clicked", Toast.LENGTH_SHORT).show();

    }
}
