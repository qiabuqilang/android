package com.example.administrator.d1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ShapeActivity extends AppCompatActivity implements View.OnClickListener{
    private View content;
    private Button rect;
    private Button oval;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        content = findViewById(R.id.v_content);
        rect = findViewById(R.id.btn_rect);
        oval = findViewById(R.id.btn_oval);
        rect.setOnClickListener(this);
        oval.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_rect){
            content.setBackgroundResource(R.drawable.shape_react);
        }
        if(view.getId() == R.id.btn_oval){
            content.setBackgroundResource(R.drawable.shape_oval);
        }
    }
}
