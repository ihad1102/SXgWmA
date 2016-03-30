package com.app.sxgwma.model;

import com.app.sxgwma.base.AppConfig;
import com.app.sxgwma.base.BaseModel;
import com.app.sxgwma.util.HttpUtil;
import com.app.sxgwma.util.MD5;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

/**
 *登录网络访问类
 */
public class LoginModel  extends BaseModel {
    public  void goLogin(String realname,String realpass){
        RequestParams params=new RequestParams();
        params.add("realname", realname);
        params.add("realpass", MD5.get32MD5(realpass));
        HttpUtil.post(AppConfig.REGISTER, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                //关闭加载
                String result = new String(responseBody);
                //函数返回值
                LoginModel.this.onCallBackData(AppConfig.REGISTER,
                        result, true);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                //显示失败信息
                String result = new String(responseBody);
                //函数返回值
                LoginModel.this.onCallBackData(AppConfig.REGISTER,
                        result, false);
            }
        });
    }
}
