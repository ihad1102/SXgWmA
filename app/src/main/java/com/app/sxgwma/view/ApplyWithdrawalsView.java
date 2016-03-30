package com.app.sxgwma.view;

/**
 * 申请提现界面的操作
 */
public interface ApplyWithdrawalsView {

    //用于获取控件内容
    String getEtAmount();
    //支付方式
    String applyType();

    //用于健壮性的判断
    void toLoginActivity(String str);

    //用于显示加载
    void showLoading();
    //用于隐藏加载
    void hideLoading();
    //加载失败
    void showFailedError();
}
