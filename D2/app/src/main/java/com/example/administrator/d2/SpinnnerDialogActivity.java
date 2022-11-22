package com.example.administrator.d2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnnerDialogActivity extends AppCompatActivity {
    private String[] starArray = {"水星", "金星", "地球", "火星", "木星", "土星"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_dialog);
        initSpinner();
    }

    private void initSpinner(){
        ArrayAdapter<String> startAdapter = new ArrayAdapter<>(this,R.layout.item_select,
                starArray);
        startAdapter.setDropDownViewResource(R.layout.item_dropdown);
        Spinner spinner = findViewById(R.id.sp_dialog);
        spinner.setPrompt("请选择行星");
        spinner.setAdapter(startAdapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new MySelectedListener());
    }

    class  MySelectedListener implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(SpinnnerDialogActivity.this,"您选择的是"+starArray[i],Toast.LENGTH_LONG)
                    .show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}
