package com.example.administrator.d2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioVerticalActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_vertical);
        RadioGroup radioGroup = findViewById(R.id.rg_marry);
        radioGroup.setOnCheckedChangeListener(this);
        textView = findViewById(R.id.tv_marry);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i ==R.id.rb_married){
            textView.setText("您已经结婚了");
        }
        if(i == R.id.rb_unmarried){
            textView.setText("您未婚");
        }
    }
}
