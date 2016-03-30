package com.app.sxgwma.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sxgwma.R;
import com.app.sxgwma.base.SimpleBaseActivity;
import com.app.sxgwma.presenter.LoginPersenter;
import com.app.sxgwma.util.HttpCallBackUtil;
import com.app.sxgwma.view.ILoginView;
import com.umeng.analytics.MobclickAgent;


/**
 * 登录
 */
public class LoginActivity extends SimpleBaseActivity implements View.OnClickListener,ILoginView,HttpCallBackUtil {
    private AppCompatAutoCompleteTextView et_user_name;
    private AppCompatEditText et_pwd;

    private LoginPersenter loginPersenter=new LoginPersenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        init();
        monitorEvent();
    }
    private void init() {
        et_user_name=(AppCompatAutoCompleteTextView)findViewById(R.id.et_user_name);
        et_pwd=(AppCompatEditText)findViewById(R.id.et_user_pwd);
    }

    private void monitorEvent(){
            findViewById(R.id.btn_login).setOnClickListener(this);
            findViewById(R.id.tv_forget_password).setOnClickListener(this);
            findViewById(R.id.iv_return).setOnClickListener(this);
            findViewById(R.id.tv_forget_password).setOnClickListener(this);
    }
   //获取用户名
    @Override
    public String getUserName() {
        return et_user_name.getText().toString().trim();
    }
   //获取密码
    @Override
    public String getUserPwd() {
        return et_pwd.getText().toString().trim();
    }
   //提示信息
    @Override
    public void toLoginActivity(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
    @Override
    public void showFailedError() {

    }
    @Override
    public void onClick(View v){

        switch(v.getId()){
            case R.id.btn_login:
//                 loginPersenter.getModel().addResponseListener(this);
//                  loginPersenter.login();
                //友盟统计账号
                //MobclickAgent.onProfileSignIn("userID");
                startActivity(new Intent(this,PersonalCenterActivity.class));
                break;
            case R.id.tv_forget_password:
                startActivity(new Intent(this,ForgetPasswordActivity.class));
                break;
            case R.id.iv_return:
                finish();
                break;

        }

    }

    @Override
    public void onCallBackData(String url, String content, boolean iscontent) {
            if (iscontent){
                this.toLoginActivity(content);
                startActivity(new Intent(this,PersonalCenterActivity.class));
            }else{
                this.toLoginActivity(content);
            }
    }
    @Override
    protected void onResume() {
        super.onResume();
        //统计页面
        MobclickAgent.onPageStart("LoginActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //统计页面
        MobclickAgent.onPageEnd("LoginActivity");
    }
}
