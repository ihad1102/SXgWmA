package com.app.sxgwma.presenter;

import com.app.sxgwma.view.ApplyWithdrawalsView;

/**
 * 申请提现
 */
public class ApplyWithdrawalsPerstenter {

    private ApplyWithdrawalsView applyWithdrawalsView;

    public  ApplyWithdrawalsPerstenter(ApplyWithdrawalsView applyWithdrawalsView){

        this.applyWithdrawalsView=applyWithdrawalsView;
    }


    public void goApplyWithdrawals(){
        if(applyWithdrawalsView.getEtAmount().isEmpty()){
            applyWithdrawalsView.toLoginActivity("请输入提现金额!!!");
        }
        else{
            //网络请求

        }
    }
}
