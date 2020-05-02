package com.example.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    private  long  milliseconds;
    private boolean running;
    long startmillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        runTimer();
    }

    public void start(View view) {
        if (startmillis == 0) {
          startmillis = System.currentTimeMillis();
        } else {
          startmillis = System.currentTimeMillis() - milliseconds;
        }
        running = true;
    }

    public void stop(View view) {
        running = false;
    }

    public void reset(View view) {
        running = false;
        milliseconds = 0;
    }

    private  void runTimer() {
        final TextView textView = findViewById(R.id.timeView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                long minute = milliseconds/60000;
                long second = (milliseconds%60000)/1000;
                long ms = milliseconds%1000;

                String time = String.format("%d:%02d.%02d", minute, second, ms/10);
                textView.setText(time);
                if(running){
                    milliseconds = System.currentTimeMillis() - startmillis;
                }
                handler.postDelayed(this, 10);
            }
        });
    }
}
