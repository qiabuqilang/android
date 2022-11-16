package com.example.administrator.d1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ClickActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        button = findViewById(R.id.btn_click);
        button.setOnClickListener(new myclick());
        button.setOnLongClickListener(new myLongClick());

    }

    class myclick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_click){
                Toast.makeText(ClickActivity.this,"您点击了控件"+((TextView)view).getText(),Toast.LENGTH_SHORT).show();
            }
        }
    }

    class myLongClick implements View.OnLongClickListener{
        @Override
        public boolean onLongClick(View view) {
            if (view.getId() == R.id.btn_click){
                Toast.makeText(ClickActivity.this,"您长按了"+((TextView)view).getText(),Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    }
}
