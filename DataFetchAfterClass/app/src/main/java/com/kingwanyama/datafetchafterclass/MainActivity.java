
package com.kingwanyama.datafetchafterclass;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayList<String> data;
    ArrayAdapter<String> adapter;
    SwipeRefreshLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.swipelist);
        refresh = (SwipeRefreshLayout) findViewById(R.id.swipe);
        data = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetch();
            }
        });

    }

    public void fetch(){
        if (!isConnected())
        {
            Toast.makeText(this, "Make sure Data is turned on", Toast.LENGTH_SHORT).show();

            refresh.setRefreshing(false);
            return;
        }

        String url = "http://jistymarketer.com/data.php";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String text = new String(responseBody);
                Log.d("MCHONGOANO", text);
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                refresh.setRefreshing(false);
                try {
                    data.clear();
                    JSONArray array = new JSONArray(text);
                    for (int i =0; i<array.length(); i++)
                    {
                        JSONObject obj = array.getJSONObject(i);
                        String item = obj.getString("item");
                        data.add(item);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(MainActivity.this, "Failed To Fetch. Kindly Retry Later", Toast.LENGTH_SHORT).show();
                refresh.setRefreshing(false);

            }
        });
    }

    public boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null)
        {
            return false;
        }



        return info.isConnected();
    }
}
