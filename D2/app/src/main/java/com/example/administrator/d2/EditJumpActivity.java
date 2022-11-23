package com.example.administrator.d2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.d2.Utils.ViewUtil;

public class EditJumpActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_jump);
        EditText etUser = findViewById(R.id.et_username);
        final EditText etPassword = findViewById(R.id.et_password);
        final Button login = findViewById(R.id.btn_login);
        etUser.addTextChangedListener(new JumpTextWatcher(etUser,etPassword));
        etPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_DONE || i== EditorInfo.IME_ACTION_NEXT){
                    ViewUtil.hideOneInputMethod(EditJumpActivity.this,etPassword);
                    login.setFocusable(true);
                    login.setFocusableInTouchMode(true);
                    login.requestFocus();
                }
                return false;
            }
        });

        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_login){
            Toast.makeText(this,"您点击了登录",Toast.LENGTH_SHORT).show();
        }
    }

    private class JumpTextWatcher implements TextWatcher{
        private EditText mEditText;
        private View mNextView;
        public JumpTextWatcher(EditText vText,View vView){
            super();
            mEditText = vText;
            if(vView != null){
                mNextView = vView;
            }

        }
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String str = editable.toString();
            if(str.contains("\r")|| str.contains("\n")){
                mEditText.setText(str.replace("\r","").replace("\n",""));
                if (mNextView !=null){
                    mNextView.requestFocus();
                    if (mNextView instanceof EditText){
                        EditText editText = (EditText) mNextView;
                        editText.setSelection(editText.getText().length());
                    }
                }
            }
        }
    }
}
