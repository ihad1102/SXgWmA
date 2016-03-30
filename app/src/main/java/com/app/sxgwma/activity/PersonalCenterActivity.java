package com.app.sxgwma.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.sxgwma.R;
import com.app.sxgwma.base.SimpleBaseActivity;
import com.app.sxgwma.fragment.GrowFragment;
import com.app.sxgwma.fragment.MoreFragment;
import com.app.sxgwma.fragment.OrderFragment;
import com.app.sxgwma.fragment.PersonalCenterFragment;
import com.app.sxgwma.fragment.XgwFragment;
import com.app.sxgwma.presenter.PresonalCenterPersenter;
import com.app.sxgwma.view.IPersonalCenterView;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * 个人中心
 */
public class PersonalCenterActivity extends SimpleBaseActivity implements View.OnClickListener,IPersonalCenterView {
    public static PresonalCenterPersenter persenter;
    //微分销系统,我的订单,成长记录,更多
    private AutoLinearLayout al_xgw,al_order,al_grow,al_more;
    private XgwFragment xgwFragment;
    private OrderFragment orderFragment;
    private GrowFragment growFragment;
    private MoreFragment moreFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_center_activity);
        getSupportFragmentManager().beginTransaction().
                add(R.id.ly_contact, new PersonalCenterFragment(), "center").commit();
        init();
        monitorEvent();
    }

    private void init(){
        persenter=new PresonalCenterPersenter(this);
        al_xgw=(AutoLinearLayout)findViewById(R.id.al_xgw);
        al_order=(AutoLinearLayout)findViewById(R.id.al_order);
        al_grow=(AutoLinearLayout)findViewById(R.id.al_grow);
        al_more=(AutoLinearLayout)findViewById(R.id.al_more);
        xgwFragment =new XgwFragment();
        orderFragment=new OrderFragment();
        growFragment=new GrowFragment();
        moreFragment=new  MoreFragment();
    }
   /**
    * 事件监听
    * */
    private void monitorEvent(){
        al_xgw.setOnClickListener(this);
        al_order.setOnClickListener(this);
        al_grow.setOnClickListener(this);
        al_more.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        selectorBackground();
        //添加一个FragmentTransaction的实例
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.al_xgw:
                al_xgw.setSelected(true);
                popAllFragmentsExceptTheBottomOne();
                transaction.addToBackStack("xgw");
                transaction.replace(R.id.ly_contact, xgwFragment, "xgw");
                break;
            case R.id.al_order:
                al_order.setSelected(true);
                popAllFragmentsExceptTheBottomOne();
                transaction.addToBackStack("order");
                transaction.replace(R.id.ly_contact, orderFragment, "order");
                break;
            case R.id.al_grow:
                al_grow.setSelected(true);
                popAllFragmentsExceptTheBottomOne();
                transaction.addToBackStack("grow");
                transaction.replace(R.id.ly_contact, growFragment, "grow");
                break;
            case R.id.al_more:
                al_more.setSelected(true);
                popAllFragmentsExceptTheBottomOne();
                transaction.addToBackStack("more");
                transaction.replace(R.id.ly_contact, moreFragment, "more");
                break;
        }
        transaction.commit();
    }
    /**
     * 设置默认背景颜色
     * */
    private void  selectorBackground(){
        al_xgw.setSelected(false);
        al_order.setSelected(false);
        al_grow.setSelected(false);
        al_more.setSelected(false);
    }
    @Override
    public void showLoading(){

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showFailedError() {

    }

    @Override
    public void showBackround(int id){
        switch (id){
            case 0:
                selectorBackground();
                break;
            case 1:
                al_xgw.setSelected(true);
                break;
            case 2:
                al_order.setSelected(true);
                break;
            case 3:
                al_grow.setSelected(true);
                break;
            case 4:
                al_more.setSelected(true);
                break;
        }
    }

    @Override
    public void hideBackround(int id){
        selectorBackground();
    }

    @Override
    public void showUIBackround(int id){

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    @Override
    protected void onPause(){
        super.onPause();

    }
    /**
     * 从back stack弹出所有的fragment，保留最后三个
     */
    public  void popAllFragmentsExceptTheBottomOne(){
        for (int i = 0, count = getSupportFragmentManager().getBackStackEntryCount()-3; i < count; i++){
            getSupportFragmentManager().popBackStack();
        }
    }
}
