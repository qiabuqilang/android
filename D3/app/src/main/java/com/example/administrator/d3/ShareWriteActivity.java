package com.example.administrator.d3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ShareWriteActivity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences mShared;
    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    private String[] typeArray = {"未婚", "已婚"};
    private boolean bMarried = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_write);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        findViewById(R.id.btn_save).setOnClickListener(this);
        mShared = getSharedPreferences("share",MODE_PRIVATE);
        initTypeSpinner();

    }
    private void initTypeSpinner(){
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this,R.layout.item_select,typeArray);
        typeAdapter.setDropDownViewResource(R.layout.item_dropdown);
        Spinner sp_married = findViewById(R.id.sp_married);
        sp_married.setPrompt("请选择婚姻状况");
        sp_married.setAdapter(typeAdapter);
        sp_married.setSelection(0);
        sp_married.setOnItemSelectedListener(new TypeSelectedListener());
    }
    class TypeSelectedListener implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            bMarried = (i==0)?false:true;
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
    @Override
    public void onClick(View view) {
        if(view.getId() ==R.id.btn_save){
            String name = et_name.getText().toString();
            String age = et_age.getText().toString();
            String height = et_height.getText().toString();
            String weight = et_weight.getText().toString();
            if(TextUtils.isEmpty(name)){
                showToast("请填写名字");
            }
            if(TextUtils.isEmpty(age)){
                showToast("请填写年龄");
            }
            if(TextUtils.isEmpty(height)){
                showToast("请填写身高");
            }
            if (TextUtils.isEmpty(weight)){
                showToast("请填写体重");
            }
            SharedPreferences.Editor editor = mShared.edit();
            editor.putString("name",name);
            editor.putInt("age",Integer.valueOf(age));
            editor.putFloat("height",Float.parseFloat(height));
            editor.putLong("weight",Long.parseLong(weight));
            editor.putBoolean("married",bMarried);
            editor.commit();
            showToast("数据已写入共享参数");
        }

    }

    private void showToast(String desc) {
        Toast.makeText(this, desc, Toast.LENGTH_SHORT).show();
    }
}