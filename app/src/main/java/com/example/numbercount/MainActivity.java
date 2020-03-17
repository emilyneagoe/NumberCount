package com.example.numbercount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView countView;
    public Button button;
    public Handler handler;
    public int count;
    public UpdateCount update;
    public boolean on;
    public Button buttonDown;
    public UpdateCountDown updateDown;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countView = findViewById(R.id.countView);
        button = findViewById(R.id.button);
        handler = new Handler();
        count = 0;
        on = false;
        update = new UpdateCount();
        updateDown = new UpdateCountDown();
        buttonDown = findViewById(R.id.buttonDown);
    }

    public void buttonPressed(View v) {
        if (on)  {
            on = false;
            handler.removeCallbacks(update);
        }  else {
            on = true;
            handler.postDelayed(update, 1000);
        }
    }

    private class UpdateCount implements Runnable {

        public void run() {
            count ++;
            countView.setText(count+"");
            handler.postDelayed(update,1000);
        }

    }



    public void buttonPressDown(View v) {
        if (on)  {
            on = false;
            handler.removeCallbacks(updateDown);
        }  else {
            on = true;
            handler.postDelayed(updateDown, 1000);
        }
    }

    private class UpdateCountDown implements Runnable {

        public void run() {
            count --;
            countView.setText(count+"");
            handler.postDelayed(updateDown,1000);
        }

    }





}

