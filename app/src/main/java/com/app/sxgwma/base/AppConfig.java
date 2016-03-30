package com.app.sxgwma.base;

/**
 *数据接口类
 */
public class AppConfig{
    //总的接口类
    private static final String ALL="http://192.168.1.188:8080/";
    private static final String all="http://192.168.1.170:8080/";
    //http://pc-20160311zatj:8080/MicroDistribution
    //注册接口
    public  static  final String REGISTER=all+"MicroDistribution/SignUp";

    //接口返回值的判断
    public static final  int SUCCESS=1;
    public static final  int ERROR=0;

}
