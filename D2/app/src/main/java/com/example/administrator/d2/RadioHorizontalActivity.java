package com.example.administrator.d2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioHorizontalActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_horizontal);
        RadioGroup radioGroup = findViewById(R.id.rg_sex);
        radioGroup.setOnCheckedChangeListener(this);
        textView = findViewById(R.id.tv_sex);

    }



    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i == R.id.rb_female){
            textView.setText("您选择了女性");
        }
        if(i == R.id.rb_male){
            textView.setText("您选择了男性");
        }
    }
}
