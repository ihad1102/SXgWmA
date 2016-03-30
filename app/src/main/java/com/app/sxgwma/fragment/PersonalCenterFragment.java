package com.app.sxgwma.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.sxgwma.R;
import com.app.sxgwma.activity.ApplyWithdrawalsActivity;
import com.app.sxgwma.activity.BecomeAgentActivity;
import com.app.sxgwma.activity.MyPerformanceActivity;
import com.app.sxgwma.activity.PersonalCenterActivity;
import com.app.sxgwma.activity.SettingActivity;
import com.app.sxgwma.base.SimpleBaseFragment;
import com.umeng.analytics.MobclickAgent;


/**
 * 个人中心
 */
public class PersonalCenterFragment extends SimpleBaseFragment implements View.OnClickListener{
    private View view;
    //用户,立即认证,姓名,代理,代理认证,代理等级,销售总额,推荐人,id
    private TextView tv_user,tv_immediate_authentication,tv_name,tv_agent,tv_become_agent,tv_agent_level,tv_total_sales,
            tv_recommended_person,tv_ids;
    //用户头像
    private ImageView ci_img;
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        PersonalCenterActivity.persenter.selectorHideBackround(0);
        view=inflater.inflate(R.layout.personal_center_fragment,container,false);
        init();
        monitorEvent();
        return view;
    }
    private void init(){
        tv_user=(TextView)view.findViewById(R.id.tv_user);
        tv_immediate_authentication=(TextView)view.findViewById(R.id.tv_immediate_authentication);
        tv_name=(TextView)view.findViewById(R.id.tv_name);
        tv_agent=(TextView)view.findViewById(R.id.tv_agent);
        tv_become_agent=(TextView)view.findViewById(R.id.tv_become_agent);
        tv_agent_level=(TextView)view.findViewById(R.id.tv_agent_level);
        tv_total_sales=(TextView)view.findViewById(R.id.tv_total_sales);
        tv_recommended_person=(TextView)view.findViewById(R.id.tv_recommended_person);
        tv_ids=(TextView)view.findViewById(R.id.tv_ids);
        ci_img=(ImageView)view.findViewById(R.id.ci_img);
    }
    private void monitorEvent(){
        tv_immediate_authentication.setOnClickListener(this);
        ci_img.setOnClickListener(this);
        tv_become_agent.setOnClickListener(this);
        view.findViewById(R.id.iv_return).setOnClickListener(this);
        view.findViewById(R.id.iv_setting).setOnClickListener(this);
        view.findViewById(R.id.ly_my_tream).setOnClickListener(this);
        view.findViewById(R.id.ly_my_performance).setOnClickListener(this);
        view.findViewById(R.id.ly_application_withdrawal).setOnClickListener(this);
    }
    @Override
    public void onResume() {
        super.onResume();
        //统计页面
        MobclickAgent.onPageStart("PersonalCenterFragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        //统计页面
        MobclickAgent.onPageEnd("PersonalCenterFragment");
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            //返回
            case R.id.iv_return:
                getActivity().finish();
                break;
            //设置
            case R.id.iv_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            //头像
            case R.id.ci_img:
                break;
            //申请提现
            case R.id.ly_application_withdrawal:
                startActivity(new Intent(getActivity(), ApplyWithdrawalsActivity.class));
                break;
            //我的业绩
            case R.id.ly_my_performance:
                startActivity(new Intent(getActivity(), MyPerformanceActivity.class));
                break;
            //我的团队
            case R.id.ly_my_tream:
                break;
            //立即认证
            case R.id.tv_immediate_authentication:
                break;
            //成为代理
            case R.id.tv_become_agent:
                startActivity(new Intent(getActivity(), BecomeAgentActivity.class));
                break;
     }
    }
}
