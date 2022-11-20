package com.example.administrator.d1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.sql.BatchUpdateException;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textViewRes;
    private TextView textViewPor;
    private String por="";
    private String res="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        textViewRes = findViewById(R.id.tv_result);
        textViewPor = findViewById(R.id.tv_process);
    }
    @Override
    public void onClick(View view) {

    }
    public void getRes(View view){

        switch (view.getId()){
            case R.id.btn_cancel:
                res ="";
                break;
            case R.id.btn_clear:
                res="";
                por="";
                textViewPor.setText(por);
                textViewRes.setText(res);
                break;
            case R.id.btn_add:
                por = res+'+';
                textViewPor.setText(por);
                res="";
                break;
            case R.id.btn_minus:
                por= res+'-';
                textViewPor.setText(por);
                break;
            case R.id.btn_multiply:
                por= res+"x";
                textViewPor.setText(por);
                break;
            case R.id.btn_division:
                por = res+ "÷";
                textViewPor.setText(por);
                break;
            case R.id.ib_sqrt:
                por = "√" + res;
                textViewPor.setText(por);
                break;
            default:
                res += ((Button)view).getText().toString();
                break;
        }

        textViewRes.setText(res);
    }
}
