package com.app.sxgwma.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.sxgwma.R;
import com.app.sxgwma.adapter.BecomwAgentAdapter;
import com.app.sxgwma.base.SimpleBaseActivity;
import com.app.sxgwma.util.LogUtil;
import com.umeng.analytics.MobclickAgent;

/**
 * 成为代理
 */
public class BecomeAgentActivity  extends SimpleBaseActivity implements View.OnClickListener{
    private RecyclerView recyclerView;
    private BecomwAgentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.become_agent_activity);
        init();
        monitorEvent();
    }


    private void init() {
        adapter=new BecomwAgentAdapter(this,0);
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

        findViewById(R.id.btn_commint).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
          switch (v.getId()){
              case R.id.iv_return:
                     finish();
                  break;

              case R.id.btn_commint:
                  LogUtil.log("选择了哪一个"+adapter.DefaultAgent);
                  break;
          }
    }
    @Override
    protected void onResume() {
        super.onResume();
        //统计页面
        MobclickAgent.onPageStart("BecomeAgentActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //统计页面
        MobclickAgent.onPageEnd("BecomeAgentActivity");
    }
}
