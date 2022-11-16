package com.example.administrator.d1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class ScaleActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        imageView = findViewById(R.id.iv_scale);
        findViewById(R.id.btn_center).setOnClickListener(this);
        findViewById(R.id.btn_fitCenter).setOnClickListener(this);
        findViewById(R.id.btn_centerCrop).setOnClickListener(this);
        findViewById(R.id.btn_centerInside).setOnClickListener(this);
        findViewById(R.id.btn_fitXY).setOnClickListener(this);
        findViewById(R.id.btn_fitStart).setOnClickListener(this);
        findViewById(R.id.btn_fitEnd).setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_center:
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                break;
            case R.id.btn_fitCenter:
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case R.id.btn_centerCrop:
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
            case R.id.btn_centerInside:
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case R.id.btn_fitXY:
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
            case R.id.btn_fitStart:
                imageView.setScaleType(ImageView.ScaleType.FIT_START);
                break;
            case R.id.btn_fitEnd:
                imageView.setScaleType(ImageView.ScaleType.FIT_END);
                break;

        }

    }
}
