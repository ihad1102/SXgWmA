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
import com.app.sxgwma.adapter.XgwAdapter;
import com.app.sxgwma.base.SimpleBaseFragment;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;


/**
 * 微分销系统
 */
public class XgwFragment  extends SimpleBaseFragment {
    private View view;

    private XgwAdapter adapter;


    private RecyclerView recyclerView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        PersonalCenterActivity.persenter.selectorHideBackround(0);
        PersonalCenterActivity.persenter.selectorShowBackround(1);
        view=inflater.inflate(R.layout.xgw_fragment,container,false);
        init();
        return view;
    }

    private void init(){
        adapter=new XgwAdapter(getActivity());
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
        //設置RecyclerView的佈局管理
        LinearLayoutManager linearLayoutManger=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManger);
        //設置動畫
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onResume() {
        super.onResume();
        //统计页面
        MobclickAgent.onPageStart("XgwFragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        //统计页面
        MobclickAgent.onPageEnd("XgwFragment");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        PersonalCenterActivity.persenter.selectorHideBackround(0);
    }
}
