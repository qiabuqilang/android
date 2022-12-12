package com.example.administrator.d3;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.d3.bean.UserInfo;
import com.example.administrator.d3.database.UserDBHelper;
import com.example.administrator.d3.util.ViewUtil;

public class LoginSqliteActivity extends AppCompatActivity implements View.OnClickListener,
        View.OnFocusChangeListener{
    private RadioGroup rg_login;
    private RadioButton rb_password;
    private RadioButton rb_verifycode;
    private EditText et_phone;
    private TextView tv_password;
    private EditText et_password;
    private Button btn_forget;
    private CheckBox ck_remember;
    private int mRequestCode = 0;
    private int mType = 0;
    private boolean bRemember = false;
    private String mPassword = "123456";
    private String mVerifyCode;
    private SharedPreferences mShared;
    private UserDBHelper userDBHelper;
    private String[] typeArray = {"个人用户", "公司用户"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sqlite);
        rg_login = findViewById(R.id.rg_login);
        rb_password = findViewById(R.id.rb_password);
        rb_verifycode = findViewById(R.id.rb_verifycode);
        et_phone = findViewById(R.id.et_phone);
        tv_password = findViewById(R.id.tv_password);
        et_password = findViewById(R.id.et_password);
        btn_forget = findViewById(R.id.btn_forget);
        ck_remember = findViewById(R.id.ck_remember);
        userDBHelper = UserDBHelper.getInstance(this,2);
        userDBHelper.openWriteLink();
        et_password.setOnFocusChangeListener(this::onFocusChange);

        initTypeSpinner();
        rg_login.setOnCheckedChangeListener(new LoginSqliteActivity.RadioListener());
        ck_remember.setOnCheckedChangeListener(new LoginSqliteActivity.CheckListener());
        et_phone.addTextChangedListener(new LoginSqliteActivity.HideTextWatcher(et_phone));
        et_password.addTextChangedListener(new LoginSqliteActivity.HideTextWatcher(et_password));
        btn_forget.setOnClickListener(this::onClick);
        findViewById(R.id.btn_login).setOnClickListener(this::onClick);

    }
    @Override
    protected void onStart() {
        super.onStart();

        if (userDBHelper == null){
            // 获得数据库帮助器的实例
            userDBHelper = UserDBHelper.getInstance(this, 2);
            // 打开数据库帮助器的写连接
            userDBHelper.openWriteLink();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        // 关闭数据库连接
        userDBHelper.closeLink();
    }

    @Override
    protected void onResume(){
        super.onResume();
        if (userDBHelper == null){
            // 获得数据库帮助器的实例
            userDBHelper = UserDBHelper.getInstance(this, 2);
            // 打开数据库帮助器的写连接
            userDBHelper.openWriteLink();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        userDBHelper.closeLink();
    }
    // 从修改密码页面返回登录页面，要清空密码的输入框
    @Override
    protected void onRestart() {
        et_password.setText("");
        super.onRestart();
    }
    private void initTypeSpinner(){
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this,R.layout.item_select,typeArray);
        typeAdapter.setDropDownViewResource(R.layout.item_dropdown);
        Spinner sp_type = findViewById(R.id.sp_type);
        sp_type.setPrompt("请选择用户类型");
        sp_type.setAdapter(typeAdapter);
        sp_type.setSelection(mType);
        sp_type.setOnItemSelectedListener(new LoginSqliteActivity.TypeSelectedListener());
    }

    @Override
    public void onClick(View view) {
        String phone = et_phone.getText().toString();
        switch (view.getId()){
        case R.id.btn_forget:
            if (phone.length()< 11){
                Toast.makeText(this,"手机号码格式不正确",Toast.LENGTH_SHORT).show();
                return;
            }
            if (rb_password.isChecked()){
                Intent intent = new Intent(this,LoginForgetActivity.class);
                intent.putExtra("phone",phone);
                startActivityForResult(intent,mRequestCode);
            }
            if (rb_verifycode.isChecked()){
                // 生成六位随机数字的验证码
                mVerifyCode = String.format("%06d", (int) (Math.random() * 1000000 % 1000000));
                // 弹出提醒对话框，提示用户六位验证码数字
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("请记住验证码");
                builder.setMessage("手机号" + phone + "，本次验证码是" + mVerifyCode + "，请输入验证码");
                builder.setPositiveButton("好的", null);
                AlertDialog alert = builder.create();
                alert.show();
            }
            break;

        case R.id.btn_login:
            if (phone.length()< 11){
                Toast.makeText(this,"手机号码格式不正确",Toast.LENGTH_SHORT).show();
                return;
            }
            if (rb_password.isChecked()){
                if (et_password.getText().toString().equals(mPassword)){
                    loginSuccess();
                }else {
                    Toast.makeText(this,"密码不正确",Toast.LENGTH_SHORT).show();
                    et_password.setText("");
                    cleanSharedParams();
                    return;
                }
            }
            if (rb_verifycode.isChecked()){
                if (et_password.getText().toString().equals(mVerifyCode)){
                    loginSuccess();
                }else{
                    Toast.makeText(this,"验证码不正确",Toast.LENGTH_SHORT).show();
                    et_password.setText("");
                    cleanSharedParams();
                    return;
                }
            }
            break;
        }
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        if (requestCode == mRequestCode && intent != null){
            mPassword = intent.getStringExtra("new_password");
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        String phone = et_phone.getText().toString();
        if (v.getId() == R.id.et_password){
            if (phone.length() > 0 && hasFocus){
                UserInfo userInfo = userDBHelper.queryByPhone(phone);
                if (userInfo != null){
                    et_password.setText(userInfo.password);
                }
            }
        }
    }


    class TypeSelectedListener implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            mType = i;
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    private class RadioListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.rb_password){
                tv_password.setText("登录密码：");
                et_password.setText("请输入密码");
                btn_forget.setText("忘记密码");
                ck_remember.setVisibility(View.VISIBLE);
            }
            if (i == R.id.rb_verifycode){
                tv_password.setText("验证码：");
                et_password.setHint("请输入验证码");
                btn_forget.setText("获取验证码");
                ck_remember.setVisibility(View.INVISIBLE);
            }
        }
    }

    private class CheckListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(compoundButton.getId() == R.id.ck_remember){
                bRemember = b;
            }
        }
    }

    private class HideTextWatcher implements TextWatcher {
        private EditText mView;
        private int mMaxLength;
        private CharSequence mStr;
        public HideTextWatcher(EditText editText){
            super();
            mView = editText;
            mMaxLength = ViewUtil.getMaxLength(editText);
        }
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            mStr = charSequence;
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(mStr)){
                return;
            }
            if ((mStr.length() == 11 && mMaxLength ==11) || (mStr.length() ==6 && mMaxLength==6)){
                ViewUtil.hideOneInputMethod(LoginSqliteActivity.this,mView);
            }
        }
    }

    private void loginSuccess(){
        String desc = String.format("您的手机号码是%s,类型是%s。恭喜in通过登录验证,点击确定按钮返回上个页面",et_phone.getText().toString(),typeArray[mType]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录成功");
        builder.setMessage(desc);
        builder.setPositiveButton("确定返回",(dialog,which)->{finish();});
        builder.setNegativeButton("我仔看看",null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        if (bRemember && rb_password.isChecked()){
            /*SharedPreferences.Editor editor = mShared.edit();
            editor.putString("phone",et_phone.getText().toString());
            editor.putString("password",et_password.getText().toString());
            editor.commit();*/
            UserInfo userInfo = new UserInfo();
            userInfo.phone = et_phone.getText().toString();
            userInfo.password = et_password.getText().toString();
            userDBHelper.insert(userInfo);
        }
    }

    private void cleanSharedParams(){
        SharedPreferences.Editor editor = mShared.edit();
        editor.putString("phone","");
        editor.putString("password","");
        editor.commit();
    }
}
