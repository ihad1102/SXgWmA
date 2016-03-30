package com.app.sxgwma.util;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * 网络类:进行网络配置
 */
public class HttpUtil{

    private  static AsyncHttpClient client=new AsyncHttpClient(); //实例化对象

    static
    {
        client.setTimeout(15000);   //设置链接超时，如果不设置，默认为10s
    }

    public static void get(String urlString,AsyncHttpResponseHandler res)    //用一个完整url获取一个string对象
    {
        client.get(urlString, res);
    }
    public static void get(String urlString,RequestParams params,AsyncHttpResponseHandler res)   //url里面带参数
    {
        client.get(urlString, params,res);
    }
    public static void get(String urlString,JsonHttpResponseHandler res)   //不带参数，获取json对象或者数组
    {
        client.get(urlString, res);
    }
    public static void get(String urlString,RequestParams params,JsonHttpResponseHandler res)   //带参数，获取json对象或者数组
    {
        client.get(urlString, params,res);
    }
    public static void get(String uString, BinaryHttpResponseHandler bHandler)   //下载数据使用，会返回byte数据
    {
        client.get(uString, bHandler);
    }
    public static AsyncHttpClient getClient()
    {
        return client;
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        try {
            client.post(url, params, responseHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void post(Context context,String url, Object object, AsyncHttpResponseHandler responseHandler) {
        try {
            StringEntity se = new StringEntity(JSON.toJSONString(object),"utf-8");
            se.setContentType(RequestParams.APPLICATION_JSON);
//            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, RequestParams.APPLICATION_JSON));
            client.post(context,url, se,RequestParams.APPLICATION_JSON, responseHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void post(Context context,String url, Object object, JsonHttpResponseHandler responseHandler) {
        try {
            StringEntity se = new StringEntity(JSON.toJSONString(object),"utf-8");
            se.setContentType(RequestParams.APPLICATION_JSON);
//            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, RequestParams.APPLICATION_JSON));
            client.post(context,url, se,RequestParams.APPLICATION_JSON, responseHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
