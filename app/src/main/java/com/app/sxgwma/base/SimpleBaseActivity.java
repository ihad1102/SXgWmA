package com.app.sxgwma.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;

/**
 * 基础activty类
 */
public class SimpleBaseActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        UmengUpdateAgent.setUpdateCheckConfig(false);
        //任意网络下都可进行更新
        UmengUpdateAgent.setUpdateOnlyWifi(false);
        //友盟自动更新
        UmengUpdateAgent.update(this);
    }
    @Override
    protected void onResume(){
        super.onResume();
        //友盟统计
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //友盟统计
        MobclickAgent.onPause(this);
    }
   //保存数据的对象
   protected  MyPreference getMyPreference(String spName) {
        return new MyPreference(spName);
    }
}
