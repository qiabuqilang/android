package com.example.administrator.d2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.administrator.d2.Utils.Utils;

import java.util.Random;

public class FrameActivity extends AppCompatActivity implements View.OnClickListener {
    private FrameLayout frameLayout;
    private Button button;
    private int[] mColorArray = {
            Color.BLACK, Color.WHITE, Color.RED, Color.YELLOW, Color.GREEN,
            Color.BLUE, Color.CYAN, Color.MAGENTA, Color.GRAY, Color.DKGRAY
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        frameLayout = findViewById(R.id.fl_content);
        button = findViewById(R.id.btn_add_frame);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_add_frame){
            int random = new Random().nextInt(mColorArray.length);
            View newView = new View(this);
            newView.setBackgroundColor(mColorArray[random]);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout
                    .LayoutParams.MATCH_PARENT,Utils.dip2px(this,30));
            newView.setLayoutParams(layoutParams);
            newView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    frameLayout.removeView(view);
                    return true;
                }
            });
            frameLayout.addView(newView);
        };
    }
}
