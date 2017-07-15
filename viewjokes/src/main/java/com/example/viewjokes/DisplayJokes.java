package com.example.viewjokes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokes extends AppCompatActivity {
    TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);
        jokeTextView = (TextView) findViewById(R.id.jokeText);
        String myJoke = getIntent().getStringExtra("MyJoke");
        jokeTextView.setText(myJoke);
    }
}
