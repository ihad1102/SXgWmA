package com.app.sxgwma.view;

/**
 *忘记密码
 */
public interface ForgetPasswordView {

    String getPhone();

    String getCode();

    String getPwd();

    //用于健壮性的判断
    void toLoginActivity(String str);
    //用于显示加载
    void showLoading();
    //用于隐藏加载
    void hideLoading();
    //加载失败
    void showFailedError();
}
