package com.app.sxgwma.view;

/**
 * 注册界面view的操作
 */
public interface IRegisterView {
    //用于获取控件内容
    String getRealName();

    String getSetPassword();

    String getConfirmPassword();

    String getEmail();

    String getPhone();

    String getIdCardNumber();

    String getCode();

    String getRecommendedPersonPhone();

    String getRecommendedPerson();

    boolean getCheckBox();

    //获取验证码
    String getIvCode();

    //用于健壮性的判断
    void toRegisterActivity(String str);
    //用于显示加载
    void showLoading();
    //用于隐藏加载
    void hideLoading();
    //加载失败
    void showFailedError();
}
