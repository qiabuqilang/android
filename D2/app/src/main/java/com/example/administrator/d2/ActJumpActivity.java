package com.example.administrator.d2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.d2.Utils.DateUtil;

public class ActJumpActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String TAG = "ActJumpActivity";
    private TextView textView;
    private String mStr = "";

    private void refreshLife(String desc){
        Log.d(TAG,desc);
        mStr  = String.format("%s%s %s %s\n",mStr, DateUtil.getNowDateTime(),TAG,desc);
        textView.setText(mStr);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_jump);
        findViewById(R.id.btn_act_next).setOnClickListener(this);
        textView = findViewById(R.id.tv_life);
    }
    @Override
    protected void onStart() { // 开始活动页面
        refreshLife("开始活动页面");
        super.onStart();
    }

    @Override
    protected void onStop() { // 停止活动页面
        refreshLife("停止活动页面");
        super.onStop();
    }

    @Override
    protected void onResume() { // 恢复活动页面
        refreshLife("恢复活动页面");
        super.onResume();
    }

    @Override
    protected void onPause() { // 暂停活动页面
        refreshLife("暂停活动页面");
        super.onPause();
    }

    @Override
    protected void onRestart() { // 重启活动页面
        refreshLife("重启活动页面");
        super.onRestart();
    }

    @Override
    protected void onDestroy() { // 销毁活动页面
        refreshLife("销毁活动页面");
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_act_next){
            Intent intent = new Intent(this,ActNextActivity.class);
            startActivityForResult(intent,0);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { // 接收返回数据
        super.onActivityResult(requestCode, resultCode, data);
        String nextLife = data.getStringExtra("life");
        refreshLife("\n" + nextLife);
        refreshLife("接收上页的结果");
    }
}
