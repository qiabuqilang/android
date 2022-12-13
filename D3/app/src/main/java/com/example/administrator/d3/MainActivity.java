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
        findViewById(R.id.btn_sqlite_create).setOnClickListener(this::onClick);
        findViewById(R.id.btn_sqlite_write).setOnClickListener(this::onClick);
        findViewById(R.id.btn_sqlite_read).setOnClickListener(this::onClick);
        findViewById(R.id.btn_login_sqlite).setOnClickListener(this::onClick);
        findViewById(R.id.btn_file_basic).setOnClickListener(this::onClick);
        findViewById(R.id.btn_file_path).setOnClickListener(this::onClick);
        findViewById(R.id.btn_text_write).setOnClickListener(this::onClick);
        findViewById(R.id.btn_text_read).setOnClickListener(this::onClick);
        findViewById(R.id.btn_image_write).setOnClickListener(this::onClick);
        findViewById(R.id.btn_image_read).setOnClickListener(this::onClick);
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
        case R.id.btn_sqlite_create:
            intent.setClass(this,SqliteCreateActivity.class);
            break;
        case R.id.btn_sqlite_write:
            intent.setClass(this,SqliteWriteActivity.class);
            break;
        case R.id.btn_sqlite_read:
            intent.setClass(this,SqliteReadActivity.class);
            break;
        case R.id.btn_login_sqlite:
            intent.setClass(this,LoginSqliteActivity.class);
            break;
        case R.id.btn_file_basic:
            intent.setClass(this,FileBasicActivity.class);
            break;
        case R.id.btn_file_path:
            intent.setClass(this,FilePathActivity.class);
            break;
        case R.id.btn_text_write:
            intent.setClass(this,TextWriteActivity.class);
            break;
        case R.id.btn_text_read:
            intent.setClass(this,TextReadActivity.class);
            break;
        case R.id.btn_image_write:
            intent.setClass(this,ImageWriteActivity.class);
            break;
        case R.id.btn_image_read:
            intent.setClass(this,ImageReadActivity.class);
            break;

        }
        startActivity(intent);
    }
}
