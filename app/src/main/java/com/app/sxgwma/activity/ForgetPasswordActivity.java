package com.app.sxgwma.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sxgwma.R;
import com.app.sxgwma.base.SimpleBaseActivity;
import com.app.sxgwma.view.ForgetPasswordView;
import com.umeng.analytics.MobclickAgent;
import com.zhy.autolayout.AutoLinearLayout;

import org.w3c.dom.Text;

/**
 *忘记密码
 */
public class ForgetPasswordActivity  extends SimpleBaseActivity implements View.OnClickListener,ForgetPasswordView{

    private AppCompatEditText et_phone,et_pwd,et_code;


    private TextView tv_code;

    private TimeCount time;

    @Override
    public String getPhone() {
        return et_phone.getText().toString().trim();
    }

    @Override
    public String getCode() {
        return et_code.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return et_pwd.getText().toString().trim();
    }

    @Override
    public void toLoginActivity(String str) {
        Toast.makeText(ForgetPasswordActivity.this,str,Toast.LENGTH_SHORT).show();
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

    /* 定义一个倒计时的内部类 */
    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
        }
        @Override
        public void onFinish(){// 计时完毕时触发
            tv_code.setText("验证码");
            tv_code.setClickable(true);
        }
        @Override
        public void onTick(long millisUntilFinished) {// 计时过程显示
            tv_code.setClickable(false);
            tv_code.setText(millisUntilFinished / 1000 + "秒");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_activity);
        init();
        monitorEvent();
        time = new TimeCount(90000, 1000);// 构造CountDownTimer对象
    }
    private void init() {
        et_phone=(AppCompatEditText)findViewById(R.id.et_phone);
        et_pwd=(AppCompatEditText)findViewById(R.id.et_pwd);
        et_code=(AppCompatEditText)findViewById(R.id.et_code);
        tv_code=(TextView)findViewById(R.id.tv_code);

    }

    private void monitorEvent() {
        findViewById(R.id.btn_complete).setOnClickListener(this);
        findViewById(R.id.ly_code).setOnClickListener(this);
        findViewById(R.id.iv_return).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //完成
            case R.id.btn_complete:

                break;
            //返回
            case R.id.iv_return:
                 finish();
                break;
            //获取验证码
            case R.id.ly_code:
                time.start();// 开始计时
                break;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        //统计页面
        MobclickAgent.onPageStart("ForgetPasswordActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //统计页面
        MobclickAgent.onPageEnd("ForgetPasswordActivity");
    }
}
