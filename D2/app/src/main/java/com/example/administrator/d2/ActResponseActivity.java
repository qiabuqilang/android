package com.example.administrator.d2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.d2.Utils.DateUtil;

public class ActResponseActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_response);
        findViewById(R.id.btn_act_response).setOnClickListener(this);
        editText = findViewById(R.id.et_response);
        textView =findViewById(R.id.tv_response);
        Bundle bundle = getIntent().getExtras();
        String request_time = bundle.getString("request_time");
        String request_content = bundle.getString("request_content");
        String desc = String.format("收到的请求消息：\n请求时间为%s\n请求内容为%s",request_time,request_content);
        textView.setText(desc);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_act_response){
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("response_time", DateUtil.getNowTime());
            bundle.putString("response_content",editText.getText().toString());
            intent.putExtras(bundle);
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
    }
}
