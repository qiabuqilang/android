package com.example.administrator.d1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.d1.Utils.DateUtil;

import java.util.Random;

public class CaptureActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{
    private TextView textView;
    private ImageView imageView;
    private String[] strings={"111111111","2222222","3333333333","44444444444"};
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            textView.setDrawingCacheEnabled(false);
            imageView.setDrawingCacheEnabled(false);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        textView = findViewById(R.id.tv_capture);
        imageView = findViewById(R.id.iv_capture);

        textView.setDrawingCacheEnabled(true);
        Button btn_chat = findViewById(R.id.btn_chat);
        Button btn_capture = findViewById(R.id.btn_capture);

        btn_chat.setOnClickListener(this);
        btn_chat.setOnLongClickListener(this);
        btn_capture.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_chat){
            int random = new Random().nextInt(4);
            String string = String.format("%S\n%S\n%S",textView.getText(), DateUtil.getNowDateTime(),strings[random]);
            textView.setText(string);
        }
        if (view.getId() == R.id.btn_capture){
            Bitmap bitmap = textView.getDrawingCache();
            imageView.setImageBitmap(bitmap);
            handler.postDelayed(runnable,200);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if(view.getId() == R.id.btn_chat){

            textView.setText("");
        }
        return true;
    }
}
