package com.example.administrator.d1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.d1.Utils.Util;

public class PxActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_px);

        int dip_10 = Util.dip2px(this,10L);
        TextView tv_padding = findViewById(R.id.tv_padding);
        tv_padding.setPadding(dip_10,dip_10,dip_10,dip_10);
    }
}
