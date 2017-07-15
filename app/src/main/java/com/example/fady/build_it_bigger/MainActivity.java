package com.example.fady.build_it_bigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button goJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goJoke = (Button) findViewById(R.id.goToJoke);
        goJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(MainActivity.this);
                endpointsAsyncTask.execute();
            }
        });
    }
}
