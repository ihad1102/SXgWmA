package com.app.sxgwma.activity;

import android.os.Bundle;
import android.view.View;

import com.app.sxgwma.R;
import com.app.sxgwma.base.SimpleBaseActivity;
import com.umeng.analytics.MobclickAgent;

/**
 * 设置
 */
public class SettingActivity  extends SimpleBaseActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);
        init();
        monitorEvent();
    }

    private void init(){
    }

    private void monitorEvent(){
           findViewById(R.id.iv_return).setOnClickListener(this);
           findViewById(R.id.rl_pwd_change).setOnClickListener(this);
           findViewById(R.id.rl_img_change).setOnClickListener(this);
           findViewById(R.id.rl_qq).setOnClickListener(this);
           findViewById(R.id.rl_weixin).setOnClickListener(this);
           findViewById(R.id.rl_zfb).setOnClickListener(this);
           findViewById(R.id.rl_yhk).setOnClickListener(this);
           findViewById(R.id.btn_exit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
           switch (v.getId()){
               //返回
               case R.id.iv_return:
                   finish();
                   break;
               //密码修改
               case R.id.rl_pwd_change:
                   break;
               //头像修改
               case R.id.rl_img_change:
                   break;
               //qq账号
               case R.id.rl_qq:
                   break;
               //微信账号
               case R.id.rl_weixin:
                   break;
               //支付宝
               case R.id.rl_zfb:
                   break;
               //银行卡账号
               case R.id.rl_yhk:
                   break;
               //退出
               case R.id.btn_exit:
                   break;
           }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //统计页面
        MobclickAgent.onPageStart("SettingActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //统计页面
        MobclickAgent.onPageEnd("SettingActivity");
    }
}
