package com.app.sxgwma.view;
/**
 * 个人中心界面view的操作
 */
public interface IPersonalCenterView {
    //用于获取控件内容
    //用于显示加载
    void showLoading();
    //用于隐藏加载
    void hideLoading();
    //加载失败
    void showFailedError();

    //用于判断哪个控件需要背景颜色
    void showBackround(int id);

    void hideBackround(int id);
    //用于设置ui界面的背景颜色
    void showUIBackround(int id);
}
