package com.app.sxgwma.base;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 全局类
 */
public class Application  extends android.app.Application{
    public static Context applicationContext;
    private static Application application;
    private static Application instance;
    /** 屏幕宽度 */
    public static int screenWidth;
    /** 屏幕高度 */
    public static int screenHeight;
    @Override
    public void onCreate(){
        super.onCreate();
        applicationContext = this;
        instance = this;
        application = this;
        //屏幕尺寸
        calcScreenSize();
    }
    public static Application getInstance()
    {
        return instance;
    }
    public static Context getContext() {
        return application;
    }
    /**
     * 计算屏幕尺寸
     */
    private void calcScreenSize()
    {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
    }
}
