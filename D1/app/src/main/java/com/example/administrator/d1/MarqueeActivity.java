package com.example.administrator.d1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MarqueeActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textView;
    private Boolean isPaused = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marquee);
        textView = findViewById(R.id.tv_marquee);
        textView.setOnClickListener(this);
        textView.requestFocus();
    }

    @Override
    public void onClick(View view) {
        this.isPaused = !this.isPaused;
        if(this.isPaused){
            textView.setFocusable(false);
            textView.setFocusableInTouchMode(false);
        }else{
            textView.setFocusable(true);
            textView.setFocusableInTouchMode(true);
            textView.requestFocus();
        }
    }
}
