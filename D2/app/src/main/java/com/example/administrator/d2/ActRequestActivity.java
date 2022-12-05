package com.example.administrator.d2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.d2.Utils.DateUtil;

public class ActRequestActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_request);
        findViewById(R.id.btn_act_request).setOnClickListener(this);
        editText = findViewById(R.id.et_request);
        textView = findViewById(R.id.tv_request);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_act_request){
            Intent intent = new Intent();
            intent.setClass(this,ActResponseActivity.class);
            intent.putExtra("request_time", DateUtil.getNowTime());
            intent.putExtra("request_content",editText.getText().toString());
            startActivityForResult(intent,0);
        }
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (data != null){
            String response_time = data.getStringExtra("response_time");
            String response_content = data.getStringExtra("response_content");
            String desc = String.format("收到的返回信息：\n应答时间%s\n应答内容%s",response_time,response_content);
            textView.setText(desc);
        }
    }
}
