package com.example.administrator.d2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_relative_xml).setOnClickListener(this);
        findViewById(R.id.btn_relative_code).setOnClickListener(this);
        findViewById(R.id.btn_frame).setOnClickListener(this);
        findViewById(R.id.btn_checkbox).setOnClickListener(this);
        findViewById(R.id.btn_switch_default).setOnClickListener(this);
        findViewById(R.id.btn_switch_ios).setOnClickListener(this);
        findViewById(R.id.btn_radio_horizontal).setOnClickListener(this);
        findViewById(R.id.btn_radio_vertical).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_relative_xml:
                intent = new Intent(this,RelativeXmlActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_relative_code:
                intent = new Intent(this,RelativeCodeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_frame:
                intent = new Intent(this, FrameActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_checkbox:
                intent = new Intent(this,CheckActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_switch_default:
                intent = new Intent(this,SwitchDefaultActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_switch_ios:
                intent = new Intent(this,SwitchIosActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_radio_horizontal:
                intent = new Intent(this,RadioHorizontalActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_radio_vertical:
                intent = new Intent(this,RadioVerticalActivity.class);
                startActivity(intent);
                break;
        }
    }
}
