package com.example.administrator.d2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class SwitchDefaultActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private TextView textView;
    private Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_default);
        textView = findViewById(R.id.tv_result);
        aSwitch = findViewById(R.id.sw_status);
        aSwitch.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String str = String.format("您%s了开关按钮",b?"打开":"关闭");
        textView.setText(str);
    }
}
