package com.app.sxgwma.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sxgwma.base.SimpleBaseActivity;
import com.app.sxgwma.R;
import com.app.sxgwma.presenter.ApplyWithdrawalsPerstenter;
import com.app.sxgwma.view.ApplyWithdrawalsView;
import com.umeng.analytics.MobclickAgent;

/**
 * 申请提现
 */
public class ApplyWithdrawalsActivity extends SimpleBaseActivity implements View.OnClickListener ,ApplyWithdrawalsView{
    private AppCompatEditText et_amount;

    private ImageView iv_zfb,iv_wzf,iv_qqzf,iv_yhk;
    private TextView tv_zfb,tv_wzf,tv_qqzf,tv_yhk;
    //支付类型
    private String paymentMethod;

    private ApplyWithdrawalsPerstenter perstenter=new ApplyWithdrawalsPerstenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_withdrawal_activity);
        init();
        monitorEvent();
    }

    private void init(){
        et_amount=(AppCompatEditText)findViewById(R.id.et_amount);
        iv_zfb=(ImageView)findViewById(R.id.iv_zfb);
        iv_wzf=(ImageView)findViewById(R.id.iv_wzf);
        iv_qqzf=(ImageView)findViewById(R.id.iv_qqzf);
        iv_yhk=(ImageView)findViewById(R.id.iv_yhk);
        tv_zfb=(TextView)findViewById(R.id.tv_zfb);
        tv_wzf=(TextView)findViewById(R.id.tv_wzf);
        tv_qqzf=(TextView)findViewById(R.id.tv_qqzf);
        tv_yhk=(TextView)findViewById(R.id.tv_yhk);
        iv_zfb.setSelected(true);
        paymentMethod=tv_zfb.getText().toString();
    }
    private void monitorEvent() {

        findViewById(R.id.iv_return).setOnClickListener(this);
        findViewById(R.id.iv_zfb).setOnClickListener(this);
        findViewById(R.id.iv_wzf).setOnClickListener(this);
        findViewById(R.id.iv_qqzf).setOnClickListener(this);
        findViewById(R.id.iv_yhk).setOnClickListener(this);
        //提交
        findViewById(R.id.btn_commint).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_return:
                    finish();
                    break;
                case R.id.iv_zfb:
                    setPaymentMethod();
                    iv_zfb.setSelected(true);
                    paymentMethod=tv_zfb.getText().toString();
                    break;
                case R.id.iv_wzf:
                    setPaymentMethod();
                    iv_wzf.setSelected(true);
                    paymentMethod=tv_wzf.getText().toString();
                    break;
                case R.id.iv_qqzf:
                    setPaymentMethod();
                    iv_qqzf.setSelected(true);
                    paymentMethod=tv_qqzf.getText().toString();
                    break;
                case R.id.iv_yhk:
                    setPaymentMethod();
                    iv_yhk.setSelected(true);
                    paymentMethod=tv_yhk.getText().toString();
                    break;
                case R.id.btn_commint:
                    perstenter.goApplyWithdrawals();
                    break;
            }
    }

   //设置支付方式
    private void setPaymentMethod(){
        iv_zfb.setSelected(false);
        iv_wzf.setSelected(false);
        iv_qqzf.setSelected(false);
        iv_yhk.setSelected(false);
    }
    @Override
    protected void onResume() {
        super.onResume();
        //统计页面
        MobclickAgent.onPageStart("ApplyWithdrawalsActivity");
    }

    @Override
    protected void onPause(){
        super.onPause();
        //统计页面
        MobclickAgent.onPageEnd("ApplyWithdrawalsActivity");
    }

    //支付金额
    @Override
    public String getEtAmount() {
        return et_amount.getText().toString().trim();
    }
   //支付方式
    @Override
    public String applyType() {
        return paymentMethod;
    }

    //消息提醒
    @Override
    public void toLoginActivity(String str) {

        Toast.makeText(ApplyWithdrawalsActivity.this,str,Toast.LENGTH_SHORT).show();

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
}
