package com.example.administrator.d2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.d2.Utils.Utils;

import java.util.Random;

public class RelativeCodeActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_code);
        relativeLayout = findViewById(R.id.rl_content);
        findViewById(R.id.btn_add_left).setOnClickListener(this);
        findViewById(R.id.btn_add_above).setOnClickListener(this);
        findViewById(R.id.btn_add_below).setOnClickListener(this);
        findViewById(R.id.btn_add_right).setOnClickListener(this);
        findViewById(R.id.btn_add_parent_bottom).setOnClickListener(this);
        findViewById(R.id.btn_add_parent_top).setOnClickListener(this);
        findViewById(R.id.btn_add_parent_left).setOnClickListener(this);
        findViewById(R.id.btn_add_parent_right).setOnClickListener(this);


    }

    public void addView(View view){

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add_left:
                addNewView(RelativeLayout.LEFT_OF, RelativeLayout.ALIGN_TOP, view.getId());
                break;
            case R.id.btn_add_above:
                addNewView(RelativeLayout.ABOVE,RelativeLayout.ALIGN_LEFT,view.getId());
                break;
            case R.id.btn_add_right:
                addNewView(RelativeLayout.RIGHT_OF,RelativeLayout.ALIGN_BOTTOM,view.getId());
                break;
            case R.id.btn_add_below:
                addNewView(RelativeLayout.BELOW,RelativeLayout.ALIGN_RIGHT,view.getId());
                break;
            case R.id.btn_add_center:
                addNewView(RelativeLayout.CENTER_IN_PARENT,-1,relativeLayout.getId());
                break;
            case R.id.btn_add_parent_left:
                addNewView(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.CENTER_VERTICAL,
                        relativeLayout.getId());
                break;
            case R.id.btn_add_parent_top:
                addNewView(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.CENTER_HORIZONTAL,
                        relativeLayout.getId());
                break;
            case R.id.btn_add_parent_right:
                addNewView(RelativeLayout.ALIGN_PARENT_RIGHT,-1,relativeLayout.getId());
                break;
            case R.id.btn_add_parent_bottom:
                addNewView(RelativeLayout.ALIGN_PARENT_BOTTOM,-1,relativeLayout.getId());
                break;

        }

    }



    private void addNewView(int firstAlign,int secondAlign,int referId){
        View view = new View(this);
        view.setBackgroundColor(0xaa66ff66);
        RelativeLayout.LayoutParams r1_params = new RelativeLayout.LayoutParams(
                Utils.dip2px(this,100),Utils.dip2px(this,100)
        );
        r1_params.addRule(firstAlign,referId);
        if (secondAlign >=0){
            r1_params.addRule(secondAlign,referId);
        }
        view.setLayoutParams(r1_params);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(RelativeCodeActivity.this,"长按了",Toast.LENGTH_SHORT);
                relativeLayout.removeView(v);
                return true;
            }
        });
        relativeLayout.addView(view);
    }

    private Integer makeRandomColor(){
        Random random = new Random();
        String red = Integer.toHexString(random.nextInt(255)).toUpperCase();
        String green =  Integer.toHexString(random.nextInt(255)).toUpperCase();
        String blue = Integer.toHexString(random.nextInt(255)).toUpperCase();
        Byte byteColor = Byte.decode("0x"+red+green+blue).byteValue();
        return byteColor.intValue();
    }
}
