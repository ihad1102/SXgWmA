package com.app.sxgwma.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sxgwma.R;
import com.app.sxgwma.base.SimpleBaseActivity;
import com.app.sxgwma.presenter.RegisterPresenter;
import com.app.sxgwma.util.HttpCallBackUtil;
import com.app.sxgwma.view.IRegisterView;
import com.app.sxgwma.view.ZProgressHUD;
import com.umeng.analytics.MobclickAgent;

/**
 *注册类
 */
public class RegisterActivity  extends SimpleBaseActivity implements IRegisterView,View.OnClickListener,HttpCallBackUtil {
    private RegisterPresenter registerPresenter=new RegisterPresenter(this);
    private ZProgressHUD progressHUD;
    private CheckBox checkbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        init();
        monitorEvent();


    }

   //初始化
    private void init(){
        registerPresenter.getModel().addResponseListener(this);
        progressHUD = ZProgressHUD.getInstance(this);
        progressHUD.setMessage("加载中");
        checkbox=(CheckBox)findViewById(R.id.checkbox);

    }
    //监听事件
    private void monitorEvent(){
        findViewById(R.id.iv_return).setOnClickListener(this);
        findViewById(R.id.tv_login).setOnClickListener(this);
    }
    //获取真实姓名
    @Override
    public String getRealName(){
       return null;
    }
   //获取设置密码
    @Override
    public String getSetPassword(){
        return null;
    }
  //获取确认密码
    @Override
    public String getConfirmPassword() {
        return null;
    }
  //获取电子邮件
    @Override
    public String getEmail(){
        return null;
    }
  //获取手机号
    @Override
    public String getPhone(){
        return null;
    }
   //获取身份证号
    @Override
    public String getIdCardNumber() {
        return null;
    }
    //获取验证码
    @Override
    public String getCode(){
        return null;
    }
    //获取验证码
    @Override
    public String getIvCode(){
        return null;
    }
    //获取推荐人手机号
    @Override
    public String getRecommendedPersonPhone(){
        return null;
    }
   //获取推荐人
    @Override
    public boolean getCheckBox() {return checkbox.isChecked();}
    //获取推荐人
    @Override
    public String getRecommendedPerson() {
        return null;
    }
   //提示信息
    @Override
    public void toRegisterActivity(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
   //显示加载
    @Override
    public void showLoading() {
        progressHUD.show();
    }
    //隐藏加载
    @Override
    public void hideLoading() {
        progressHUD.dismiss();
    }
    //加载失败
    @Override
    public void showFailedError() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_return:
                finish();
                break;
            case R.id.tv_login:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                break;
            case R.id.btn_register:
                //友盟统计账号
                //MobclickAgent.onProfileSignIn("userID");
                break;
        }
    }
   //网络数据返回值
    @Override
    public void onCallBackData(String url, String content, boolean iscontent){
        if(iscontent){
            this.toRegisterActivity(content);
            startActivity(new Intent(this, LoginActivity.class));
        }else{

            this.toRegisterActivity(content);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        //统计页面
        MobclickAgent.onPageStart("RegisterActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //统计页面
        MobclickAgent.onPageEnd("RegisterActivity");
    }
}
