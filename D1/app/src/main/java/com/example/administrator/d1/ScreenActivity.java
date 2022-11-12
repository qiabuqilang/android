package com.example.administrator.d1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.d1.Utils.Util;

public class ScreenActivity extends AppCompatActivity {
    private TextView tv_screen;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_screen);
        tv_screen = findViewById(R.id.tv_screen);
        showScreenInfo();
    }

    private void showScreenInfo(){
        int width = Util.getScreenWidth(this);
        int height = Util.getScreenHeight(this);
        float desity = Util.getScreenDensity(this);
        String info = String.format("当前屏幕得宽度%dpx,高度%dpx,像素密度%f",width,height,desity);
        tv_screen.setText(info);

    }
}
