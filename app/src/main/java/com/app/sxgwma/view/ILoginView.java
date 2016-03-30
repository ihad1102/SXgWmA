package com.app.sxgwma.view;

/**
 * 登录界面view的操作
 */
public interface ILoginView {
    //用于获取控件内容
    String getUserName();

    String getUserPwd();
    //用于健壮性的判断
    void toLoginActivity(String str);
    //用于显示加载
    void showLoading();
    //用于隐藏加载
    void hideLoading();
    //加载失败
    void showFailedError();
}
