package com.example.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    private  int seconds;
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
        seconds = 0;
    }
    
    private  void runStopwatch() {
        final TextView textView = (TextView) findViewById(R.id.timeView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int Hours = seconds/3600;
                int Minutes = (seconds%3600)/60;
                int Seconds = seconds%60;

                String time = String.format("%d:%02d:%02d", Hours, Minutes, Seconds);
                textView.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
