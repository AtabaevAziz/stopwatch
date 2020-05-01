package com.example.stopwatch;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    private  int milliseconds;
    private boolean running;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runStopwatch();
    }

    public void start(View view) {
        running = true;
    }

    public void stop(View view) {
        running = false;
    }

    public void reset(View view) {
        running = false;
        milliseconds = 0;
    }

    private  void runStopwatch() {
        final TextView textView = findViewById(R.id.timeView);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int minutes = milliseconds /600;
                int seconds = (milliseconds %100)/100;
                int millisec = milliseconds %100;

                @SuppressLint("DefaultLocale") String time = String.format("%d:%02d:%02d", minutes, seconds, millisec);
                textView.setText(time);
                if(running){
                    milliseconds++;
                }
            }
        },100);
    }
}
