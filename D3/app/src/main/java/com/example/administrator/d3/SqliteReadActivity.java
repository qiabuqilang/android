package com.example.administrator.d3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.d3.bean.UserInfo;
import com.example.administrator.d3.database.UserDBHelper;

import java.util.ArrayList;

public class SqliteReadActivity extends AppCompatActivity implements View.OnClickListener{

    private UserDBHelper mHelper; // 声明一个用户数据库帮助器的对象
    private TextView tv_sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_read);
        mHelper = UserDBHelper.getInstance(this,2);
        mHelper.openReadLink();
        tv_sqlite = findViewById(R.id.tv_sqlite);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        readSQLite();
    }
    @Override
    protected void onStart(){
        super.onStart();
        if (mHelper == null){
            mHelper = UserDBHelper.getInstance(this,2);
            mHelper.openReadLink();
        }

    }
    @Override
    protected void onStop(){
        super.onStop();
        mHelper.closeLink();
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_delete){
            mHelper.closeLink();
            mHelper.openWriteLink();
            mHelper.deleteAll();
            mHelper.closeLink();
            mHelper.openReadLink();
            readSQLite();
        }
    }
    private void showToast(String desc) {
        Toast.makeText(this, desc, Toast.LENGTH_SHORT).show();
    }
    private void readSQLite() {
        if (mHelper == null) {
            showToast("数据库连接为空");
            return;
        }
        // 执行数据库帮助器的查询操作
        ArrayList<UserInfo> userArray = mHelper.query("1=1");
        String desc = String.format("数据库查询到%d条记录，详情如下：", userArray.size());
        for (int i = 0; i < userArray.size(); i++) {
            UserInfo info = userArray.get(i);
            desc = String.format("%s\n第%d条记录信息如下：", desc, i + 1);
            desc = String.format("%s\n　姓名为%s", desc, info.name);
            desc = String.format("%s\n　年龄为%d", desc, info.age);
            desc = String.format("%s\n　身高为%d", desc, info.height);
            desc = String.format("%s\n　体重为%f", desc, info.weight);
            desc = String.format("%s\n　婚否为%b", desc, info.married);
            desc = String.format("%s\n　更新时间为%s", desc, info.update_time);
        }
        if (userArray.size() <= 0) {
            desc = "数据库查询到的记录为空";
        }
        tv_sqlite.setText(desc);
    }
}
