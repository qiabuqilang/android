package com.example.administrator.d1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_px).setOnClickListener(this);
        findViewById(R.id.btn_color).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btn_px:
               intent = new Intent(this,PxActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_color:
                intent = new Intent(this,ColorActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_screen:
                intent = new Intent(this,ScreenActivity.class);
                startActivity(intent);
                break;
        }
    }
}
