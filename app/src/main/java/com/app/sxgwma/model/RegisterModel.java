package com.app.sxgwma.model;

import com.alibaba.fastjson.JSON;
import com.app.sxgwma.base.AppConfig;
import com.app.sxgwma.base.BaseModel;
import com.app.sxgwma.bean.RegisterBean;
import com.app.sxgwma.util.HttpUtil;
import com.app.sxgwma.util.MD5;
import com.app.sxgwma.view.IRegisterView;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

/**
 * 注册网络访问类
 */
public class RegisterModel extends BaseModel {
    public  void goRegister(String realname,String realpass,String email,String phone,String idcard,final IRegisterView registerView){
        RequestParams params=new RequestParams();
        params.add("realname", realname);
        params.add("realpass", MD5.get32MD5(realpass));
        params.add("email", email);
        params.add("phone", phone);
        params.add("idcard", idcard);
        HttpUtil.post(AppConfig.REGISTER, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                //关闭加载
                registerView.hideLoading();
                String result = new String(responseBody);
                RegisterBean bean = JSON.parseObject(result, RegisterBean.class);
                if (bean.getRet() == AppConfig.SUCCESS) {
                    //函数返回值
                    RegisterModel.this.onCallBackData(AppConfig.REGISTER,
                            bean.getXg_wfx_msg(), true);
                } else {
                    RegisterModel.this.onCallBackData(AppConfig.REGISTER,
                            bean.getXg_wfx_msg(), false);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                //显示失败信息
                registerView.hideLoading();
                String result = new String(responseBody);
                //函数返回值
                RegisterModel.this.onCallBackData(AppConfig.REGISTER,
                        result, false);
            }
        });
    }

}
