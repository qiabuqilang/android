package com.example.administrator.d2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_mqrquee;
    private boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_mqrquee = findViewById(R.id.tv_marquee);
        tv_mqrquee.setOnClickListener(this);
        tv_mqrquee.requestFocus();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_marquee){
            isPaused = !isPaused;
        };
        if(isPaused){
            tv_mqrquee.setFocusable(false);
            tv_mqrquee.setFocusableInTouchMode(false);
        }else{
            tv_mqrquee.setFocusable(true);
            tv_mqrquee.setFocusableInTouchMode(true);
            tv_mqrquee.requestFocus();
        }
    }
}
