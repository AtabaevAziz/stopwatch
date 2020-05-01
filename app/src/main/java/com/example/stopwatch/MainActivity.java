package com.example.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    private  int  milliseconds;
    private boolean running;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runTimer();
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

    private  void runTimer() {
        final TextView textView = findViewById(R.id.timeView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int minute = milliseconds/6000;
                int second = (milliseconds%6000)/100;
                int millisecond = milliseconds%100;

                String time = String.format("%d:%02d:%02d", minute, second, millisecond);
                textView.setText(time);
                if(running){
                    milliseconds++;
                }
                handler.postDelayed(this, 10);
            }
        });
    }
}
