package com.example.administrator.d2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class EditAutoActivity extends AppCompatActivity {
    private String[] hintArray = {"第一", "第一次", "第一次写代码", "第一次领工资", "第二", "第二个"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_auto);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.ac_text);
        ArrayAdapter<String> arrayAdapter  = new ArrayAdapter<>(this,R.layout.item_dropdown,
                hintArray);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }
}
