package com.app.sxgwma.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.app.sxgwma.R;
import com.app.sxgwma.base.SimpleBaseActivity;
import com.umeng.analytics.MobclickAgent;

public class MainActivity extends SimpleBaseActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        event();
    }
  /**
   * 事件监听
   * */
    private void event(){
        findViewById(R.id.btn_register).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                 startActivity(new Intent(MainActivity.this,LoginActivity.class));
                break;

            case R.id.btn_register:
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
                break;

        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        //统计页面
        MobclickAgent.onPageStart("MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //统计页面
        MobclickAgent.onPageEnd("MainActivity");
    }
}
