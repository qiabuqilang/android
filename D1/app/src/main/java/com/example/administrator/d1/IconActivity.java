package com.example.administrator.d1;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IconActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    private Drawable drawable;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);
        button = findViewById(R.id.btn_icon);
        drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        findViewById(R.id.btn_left).setOnClickListener(this);
        findViewById(R.id.btn_right).setOnClickListener(this);
        findViewById(R.id.btn_top).setOnClickListener(this);
        findViewById(R.id.btn_bottom).setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_left:
                button.setCompoundDrawables(drawable,null,null,null);
                break;
            case R.id.btn_right:
                button.setCompoundDrawables(null,null,drawable,null);
                break;
            case R.id.btn_top:
                button.setCompoundDrawables(null,drawable,null,null);
                break;
            case R.id.btn_bottom:
                button.setCompoundDrawables(null,null,null,drawable);
                break;
        }
    }
}
