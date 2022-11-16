package com.example.administrator.d1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.d1.Utils.DateUtil;

import java.util.Random;

public class BbsActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{
    private TextView controller;
    private TextView bbs;
    private String[] words = {"11111111","2222222222","33333333333","444444444444","5555555555555"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbs);
        controller = findViewById(R.id.tv_control);
        bbs = findViewById(R.id.tv_bbs);
        controller.setOnClickListener(this);
        controller.setOnLongClickListener(this);
        bbs.setOnClickListener(this);
        bbs.setOnLongClickListener(this);
        bbs.setGravity(Gravity.LEFT | Gravity.BOTTOM);
        bbs.setLines(8);
        bbs.setMaxLines(8);
        bbs.setMovementMethod(new ScrollingMovementMethod());
    }
    @Override
    public void onClick(View view) {
        int random = new Random().nextInt(4);
        if(view.getId() == R.id.tv_control || view.getId()== R.id.tv_bbs){
            String string = String.format("%s\n%s\n%s",bbs.getText().toString(), DateUtil.getNowDateTime(),words[random]);
            bbs.setText(string);
        }

    }

    @Override
    public boolean onLongClick(View view) {
        if(view.getId() == R.id.tv_control || view.getId()== R.id.tv_bbs){

            bbs.setText("");
        }
        return false;
    }
}
