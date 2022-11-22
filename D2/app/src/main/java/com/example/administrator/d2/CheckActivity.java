package com.example.administrator.d2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

public class CheckActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private CheckBox system;
    private CheckBox custom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        system = findViewById(R.id.ck_system);
        custom = findViewById(R.id.ck_custom);
        system.setOnCheckedChangeListener(this);
        custom.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String str = String.format("您%s了这个checkbox",b?"勾选":"取消勾选");
        compoundButton.setText(str);

    }
}
