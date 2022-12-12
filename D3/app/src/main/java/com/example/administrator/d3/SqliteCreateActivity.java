package com.example.administrator.d3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SqliteCreateActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textView;
    private String databaseName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_create);
        textView = findViewById(R.id.tv_database);
        findViewById(R.id.btn_database_create).setOnClickListener(this);
        findViewById(R.id.btn_database_delete).setOnClickListener(this);
        databaseName = getFilesDir() + "/test.db";
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_database_create){
            SQLiteDatabase database = openOrCreateDatabase(databaseName, Context.MODE_PRIVATE,
                    null);
            String desc = String.format("数据库%s创建%s",databaseName,(database != null)?"成功":"失败");
            textView.setText(desc);
        }
        if (view.getId() == R.id.btn_database_delete){
            Boolean result = deleteDatabase(databaseName);
            String desc = String.format("数据库%s删除%s",databaseName,result?"成功":"失败");
            textView.setText(desc);
        }
    }
}
