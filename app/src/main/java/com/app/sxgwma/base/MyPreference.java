package com.app.sxgwma.base;

import android.content.SharedPreferences;

/**
 * 数据保存类
 */
public class MyPreference{
    private static SharedPreferences settings = null;

    public MyPreference(String spName){
       settings=Application.getContext().getSharedPreferences(spName,0);
    }
   /**
    * 保存登录信息(userPws使用MD5保存)
    * */
   public  boolean setLoinInfo(String userName,String userPwd){
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("userName", userName);
        editor.putString("userPwd", userPwd);
        return editor.commit();
    }
    /**
     * 获取登录名信息
     * */
    public  String getuserName() {
        return settings.getString("userName", "");
    }
}
