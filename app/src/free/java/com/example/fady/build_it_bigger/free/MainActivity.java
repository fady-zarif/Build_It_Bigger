package com.example.fady.build_it_bigger.free;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.fady.build_it_bigger.EndpointsAsyncTask;
import com.example.fady.build_it_bigger.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    Button goJoke;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdView = (AdView) findViewById(R.id.adView);
        goJoke = (Button) findViewById(R.id.goToJoke);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        goJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(MainActivity.this);
                endpointsAsyncTask.execute();
            }
        });
    }
}
