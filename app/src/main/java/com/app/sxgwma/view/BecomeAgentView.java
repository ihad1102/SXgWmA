package com.app.sxgwma.view;

/**
 * 成为代理
 */
public interface BecomeAgentView {

    //获取几级代理
     String getAgent();

    //用于健壮性的判断
    void toLoginActivity(String str);

    //用于显示加载
    void showLoading();
    //用于隐藏加载
    void hideLoading();
    //加载失败
    void showFailedError();
}
