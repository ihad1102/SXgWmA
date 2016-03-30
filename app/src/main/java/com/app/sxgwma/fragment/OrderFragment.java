package com.app.sxgwma.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.sxgwma.R;
import com.app.sxgwma.activity.PersonalCenterActivity;
import com.app.sxgwma.adapter.OrderAdapter;
import com.app.sxgwma.base.SimpleBaseFragment;
import com.umeng.analytics.MobclickAgent;

/**
 * 我的订单
 */
public class OrderFragment  extends SimpleBaseFragment  implements View.OnClickListener{
    private View view;
    private RecyclerView recyclerView;

    private OrderAdapter adapter;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        PersonalCenterActivity.persenter.selectorHideBackround(0);
        PersonalCenterActivity.persenter.selectorShowBackround(2);
        view=inflater.inflate(R.layout.order_fragment,container,false);
        init();
        monitorEvent();
        return view;
    }


    private void init() {
        adapter=new OrderAdapter(getActivity());
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
        //設置RecyclerView的佈局管理
        LinearLayoutManager linearLayoutManger=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManger);
        //設置動畫
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    private void monitorEvent(){
        view.findViewById(R.id.iv_return).setOnClickListener(this);
    }
    @Override
    public void onResume() {
        super.onResume();
        //统计页面
        MobclickAgent.onPageStart("OrderFragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        //统计页面
        MobclickAgent.onPageEnd("OrderFragment");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        PersonalCenterActivity.persenter.selectorHideBackround(0);
    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.iv_return:
                 getFragmentManager().popBackStack();
                 break;
         }
    }
}
