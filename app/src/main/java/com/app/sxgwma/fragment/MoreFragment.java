package com.app.sxgwma.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.sxgwma.R;
import com.app.sxgwma.activity.PersonalCenterActivity;
import com.app.sxgwma.base.SimpleBaseFragment;
import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;

/**
 * 更多
 */
public class MoreFragment extends SimpleBaseFragment implements View.OnClickListener{
    private View view;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.more_fragment,container,false);
        PersonalCenterActivity.persenter.selectorHideBackround(0);
        PersonalCenterActivity.persenter.selectorShowBackround(4);
        init();
        monitorEvent();
        return view;
    }
    private void init(){

    }

    private void monitorEvent() {
         view.findViewById(R.id.rl_empty_cache).setOnClickListener(this);
         view.findViewById(R.id.rl_feedback).setOnClickListener(this);
         view.findViewById(R.id.rl_invite_friends).setOnClickListener(this);
         view.findViewById(R.id.rl_check_updates).setOnClickListener(this);
         view.findViewById(R.id.rl_join_us).setOnClickListener(this);
         view.findViewById(R.id.rl_service_agreement).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                //清除缓存
                case R.id.rl_empty_cache:
                    break;
                //意见反馈
                case R.id.rl_feedback:
                    break;
                //推荐给朋友
                case R.id.rl_invite_friends:
                    break;
                //版本号
                case R.id.rl_check_updates:
                    UmengUpdateAgent.forceUpdate(getActivity());
                    break;
                //关于我们
                case R.id.rl_join_us:
                    break;
                //服务协议
                case R.id.rl_service_agreement:
                    break;
            }
    }
    @Override
    public void onResume() {
        super.onResume();
        //统计页面
        MobclickAgent.onPageStart("MoreFragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        //统计页面
        MobclickAgent.onPageEnd("MoreFragment");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        PersonalCenterActivity.persenter.selectorHideBackround(0);
    }
}
