package com.example.administrator.d2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpinnerIconActivity extends AppCompatActivity {
    // 定义下拉列表需要显示的行星图标数组
    private int[] iconArray = {R.drawable.shuixing, R.drawable.jinxing, R.drawable.diqiu,
            R.drawable.huoxing, R.drawable.muxing, R.drawable.tuxing};
    // 定义下拉列表需要显示的行星名称数组
    private String[] starArray = {"水星", "金星", "地球", "火星", "木星", "土星"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_icon);
        initSpinnerForSimpleAdapter();
    }

    private void initSpinnerForSimpleAdapter(){
        List<Map<String,Object>> list = new ArrayList<>();
        for (int i=0;i< iconArray.length;i++){
            Map<String,Object> item = new HashMap<>();
            item.put("icon",iconArray[i]);
            item.put("name",starArray[i]);
            list.add(item);
        }
        SimpleAdapter startAdapter = new SimpleAdapter(this,list,R.layout.item_simple,new
                String[]{"icon","name"},new int[]{R.id.iv_icon,R.id.tv_name});
        startAdapter.setDropDownViewResource(R.layout.item_simple);
        Spinner spinner = findViewById(R.id.sp_icon);
        spinner.setPrompt("请选择行星");
        spinner.setAdapter(startAdapter);
        spinner.setSelection(0);;
        spinner.setOnItemSelectedListener(new MySelectedListener());
    }

    class  MySelectedListener implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(SpinnerIconActivity.this,"您选择的是"+starArray[i],Toast.LENGTH_LONG)
                    .show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

}
