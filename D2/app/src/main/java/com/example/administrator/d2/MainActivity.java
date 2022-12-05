package com.example.administrator.d2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_relative_xml).setOnClickListener(this);
        findViewById(R.id.btn_relative_code).setOnClickListener(this);
        findViewById(R.id.btn_frame).setOnClickListener(this);
        findViewById(R.id.btn_checkbox).setOnClickListener(this);
        findViewById(R.id.btn_switch_default).setOnClickListener(this);
        findViewById(R.id.btn_switch_ios).setOnClickListener(this);
        findViewById(R.id.btn_radio_horizontal).setOnClickListener(this);
        findViewById(R.id.btn_radio_vertical).setOnClickListener(this);
        findViewById(R.id.btn_spinner_dropdown).setOnClickListener(this);
        findViewById(R.id.btn_spinner_dialog).setOnClickListener(this);
        findViewById(R.id.btn_spinner_icon).setOnClickListener(this);
        findViewById(R.id.btn_edit_simple).setOnClickListener(this);
        findViewById(R.id.btn_edit_cursor).setOnClickListener(this);
        findViewById(R.id.btn_edit_border).setOnClickListener(this);
        findViewById(R.id.btn_edit_hide).setOnClickListener(this);
        findViewById(R.id.btn_edit_jump).setOnClickListener(this);
        findViewById(R.id.btn_edit_auto).setOnClickListener(this);
        findViewById(R.id.btn_act_jump).setOnClickListener(this);
        findViewById(R.id.btn_act_rotate).setOnClickListener(this);
        findViewById(R.id.btn_act_home).setOnClickListener(this);
        findViewById(R.id.btn_act_uri).setOnClickListener(this);
        findViewById(R.id.btn_act_request).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_relative_xml:
                intent = new Intent(this,RelativeXmlActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_relative_code:
                intent = new Intent(this,RelativeCodeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_frame:
                intent = new Intent(this, FrameActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_checkbox:
                intent = new Intent(this,CheckActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_switch_default:
                intent = new Intent(this,SwitchDefaultActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_switch_ios:
                intent = new Intent(this,SwitchIosActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_radio_horizontal:
                intent = new Intent(this,RadioHorizontalActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_radio_vertical:
                intent = new Intent(this,RadioVerticalActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_spinner_dropdown:
                intent = new Intent(this,SpinnerDropdownActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_spinner_dialog:
                intent = new Intent(this,SpinnnerDialogActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_spinner_icon:
                intent = new Intent(this,SpinnerIconActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_edit_simple:
                intent = new Intent(this,EditSimpleActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_edit_cursor:
                intent = new Intent(this,EditCursorActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_edit_border:
                intent = new Intent(this,EditBorderActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_edit_hide:
                intent = new Intent(this,EditHideActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_edit_jump:
                intent = new Intent(this,EditJumpActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_edit_auto:
                intent = new Intent(this,EditAutoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_act_jump:
                intent = new Intent(this,ActJumpActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_act_rotate:
                intent = new Intent(this,ActRotateActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_act_home:
                intent = new Intent(this,ActHomeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_act_uri:
                intent = new Intent(this,ActUriActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_act_request:
                intent = new Intent(this,ActRequestActivity.class);
                startActivity(intent);
                break;
        }
    }
}
