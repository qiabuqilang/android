package com.example.administrator.d2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ActUriActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_uri);
        findViewById(R.id.btn_call).setOnClickListener(this);
        findViewById(R.id.btn_dial).setOnClickListener(this);
        findViewById(R.id.btn_sms).setOnClickListener(this);
        editText = findViewById(R.id.et_phone);
    }
    @Override
    public void onClick(View view) {
        String phone = editText.getText().toString();
        Intent intent = new Intent();
        Uri uri  = Uri.EMPTY;
        switch (view.getId()){
            case R.id.btn_call:

                intent.setAction(Intent.ACTION_CALL);
                uri = Uri.parse("tel:"+phone);
                intent.setData(uri);
                startActivity(intent);
                break;
            case R.id.btn_dial:
               intent.setAction(Intent.ACTION_DIAL);
                uri = Uri.parse("tel"+phone);
                intent.setData(uri);
                startActivity(intent);
                break;
            case R.id.btn_sms:
                intent.setAction(Intent.ACTION_SENDTO);
                uri = Uri.parse("smsto:"+phone);
                intent.setData(uri);
                startActivity(intent);
                break;
        }
    }
}
