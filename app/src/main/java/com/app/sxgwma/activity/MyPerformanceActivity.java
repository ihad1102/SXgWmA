package com.app.sxgwma.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.sxgwma.R;
import com.app.sxgwma.adapter.MyPerformanceAdapter;
import com.app.sxgwma.base.SimpleBaseActivity;
import com.umeng.analytics.MobclickAgent;

/**
 * 我的业绩
 */
public class MyPerformanceActivity extends SimpleBaseActivity implements View.OnClickListener{
    private RecyclerView recyclerView;

    private MyPerformanceAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_performance_activity);
        init();
        monitorEvent();
    }

    private void init() {
        adapter=new MyPerformanceAdapter(this);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        //設置RecyclerView的佈局管理
        LinearLayoutManager linearLayoutManger=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManger);
        //設置動畫
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void monitorEvent() {
           findViewById(R.id.iv_return).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
          switch (v.getId()){
              case R.id.iv_return:
                  finish();
                  break;
          }
    }
    @Override
    protected void onResume() {
        super.onResume();
        //统计页面
        MobclickAgent.onPageStart("MyPerformanceActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //统计页面
        MobclickAgent.onPageEnd("MyPerformanceActivity");
    }
}
