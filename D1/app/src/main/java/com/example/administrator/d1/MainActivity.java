package com.example.administrator.d1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_px).setOnClickListener(this);
        findViewById(R.id.btn_color).setOnClickListener(this);
        findViewById(R.id.btn_screen).setOnClickListener(this);
        findViewById(R.id.btn_margin).setOnClickListener(this);
        findViewById(R.id.btn_gravity).setOnClickListener(this);
        findViewById(R.id.btn_scroll).setOnClickListener(this);
        findViewById(R.id.btn_marquee).setOnClickListener(this);
        findViewById(R.id.btn_bbs).setOnClickListener(this);
        findViewById(R.id.btn_click).setOnClickListener(this);
        findViewById(R.id.btn_scale).setOnClickListener(this);
        findViewById(R.id.btn_capture).setOnClickListener(this);
        findViewById(R.id.btn_icon).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btn_px:
               intent = new Intent(this,PxActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_color:
                intent = new Intent(this,ColorActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_screen:
                intent = new Intent(this,ScreenActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_margin:
                intent = new Intent(this,MarginActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_gravity:
                intent = new Intent(this,GravityActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_scroll:
                intent = new Intent(this,ScrollActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_marquee:
                intent = new Intent(this,MarqueeActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_bbs:
                intent = new Intent(this,BbsActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_click:
                intent = new Intent(this,ClickActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_scale:
                intent = new Intent(this,ScaleActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_capture:
                intent = new Intent(this,CaptureActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_icon:
                intent = new Intent(this, IconActivity.class);
                startActivity(intent);
                break;

        }
    }
}
