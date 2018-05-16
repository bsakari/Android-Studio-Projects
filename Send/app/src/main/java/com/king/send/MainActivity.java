package com.king.send;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Send(View view) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"Initiator\":\" \",
                \"SecurityCredential\":\" \",
                \"CommandID\":\"AccountBalance\",
                \"PartyA\":\" \",
                \"IdentifierType\":\"4\",
                \"Remarks\":\" \",
                \"QueueTimeOutURL\":\"https://ip_address:port/timeout_url\",
                \"ResultURL\":\"https://ip_address:port/result_url\"}");
        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/mpesa/accountbalance/v1/query")
                .post(body)
                .addHeader("authorization", "Bearer ACCESS_TOKEN")
                .addHeader("content-type", "application/json")
                .build();

        Response response = client.newCall(request).execute();





    }

    public void pesa(View view) {
        Intent simToolKitLaunchIntent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.android.stk");
        if(simToolKitLaunchIntent != null) {
            startActivity(simToolKitLaunchIntent);
        }

    }
}



















