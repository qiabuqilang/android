package com.example.administrator.d2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.d2.Utils.DateUtil;

public class ActNextActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = "ActNextActivity";
    private TextView tv_life; // 声明一个文本视图对象
    private String mStr = "";

    private void refreshLife(String desc) { // 刷新生命周期的日志信息
        Log.d(TAG, desc);
        mStr = String.format("%s    %s %s %s\n", mStr, DateUtil.getNowTimeDetail(), TAG, desc);
        tv_life.setText(mStr);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 创建活动页面
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_next);
        findViewById(R.id.btn_act_prev).setOnClickListener(this);
        // 从布局文件中获取名叫tv_life的文本视图
        tv_life = findViewById(R.id.tv_life);
        refreshLife("创建活动页面");
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
    public void onClick(View v) {
        if (v.getId() == R.id.btn_act_prev) {
            Intent intent = new Intent(); // 创建一个新意图
            intent.putExtra("life", mStr); // 把字符串参数塞给意图
            setResult(Activity.RESULT_OK, intent); // 携带意图返回前一个页面
            finish(); // 关闭当前页面
        }
    }
}
