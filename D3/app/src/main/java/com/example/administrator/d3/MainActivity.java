package com.example.administrator.d3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_share_write).setOnClickListener(this);
        findViewById(R.id.btn_share_read).setOnClickListener(this);
        findViewById(R.id.btn_login_share).setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.btn_share_write:
                intent.setClass(this,ShareWriteActivity.class);
                break;
            case R.id.btn_share_read:
                intent.setClass(this,ShareReadActivity.class);
                break;
        case R.id.btn_login_share:
            intent.setClass(this,LoginShareActivity.class);
            break;
        }
        startActivity(intent);
    }
}
