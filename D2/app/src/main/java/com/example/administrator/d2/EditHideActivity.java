package com.example.administrator.d2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.administrator.d2.Utils.ViewUtil;

public class EditHideActivity extends AppCompatActivity implements View.OnClickListener{
    private  EditText etOther;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hide);
        EditText etPhone = findViewById(R.id.et_phone);
        EditText etPassword = findViewById(R.id.et_password);
        etOther = findViewById(R.id.et_other);
        LinearLayout linearLayout = findViewById(R.id.ll_hide);
        linearLayout.setOnClickListener(this);
        etPhone.addTextChangedListener(new HideTextWatcher(etPhone));
        etPassword.addTextChangedListener(new HideTextWatcher(etPassword));

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.ll_hide){
            ViewUtil.hideOneInputMethod(EditHideActivity.this,etOther);
        }
    }

    private class HideTextWatcher implements TextWatcher{
        private EditText editText;
        private int mMaxLength;
        private CharSequence mStr;
        public HideTextWatcher(EditText v){
            super();
            editText = v;
            mMaxLength = ViewUtil.getMaxLength(v);
        }
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(editable.length() == mMaxLength && mMaxLength==11){
                ViewUtil.hideAllInputMethod(EditHideActivity.this);
            }
            if (editable.length() == mMaxLength && mMaxLength == 6){
                ViewUtil.hideOneInputMethod(EditHideActivity.this,editText);
            }
        }


    }
}
