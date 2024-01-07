package com.avci.javamobilkronometreugulamasi;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Handler;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Chronometer;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Runnable runnable;
    Handler handler;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        start = findViewById(R.id.start);
        number = 0;

    }

    public void start(View view) {
        start.setEnabled(false);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Duration: " + number);
                number++;
                textView.setText("Duration: " + number);
                handler.postDelayed(runnable, 1000);
            }
        };
        handler.post(runnable);
    }

    public void stop(View view) {
        start.setEnabled(true);
        handler.removeCallbacks(runnable);
        number=0;
        textView.setText("Duration: " + number);
    }

   }

