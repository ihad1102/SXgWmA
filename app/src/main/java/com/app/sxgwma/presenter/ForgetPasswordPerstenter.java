package com.app.sxgwma.presenter;

import com.app.sxgwma.util.StringUtils;
import com.app.sxgwma.view.ForgetPasswordView;

/**
 * 忘记密码
 */
public class ForgetPasswordPerstenter {

    private ForgetPasswordView forgetPasswordView;

    public  ForgetPasswordPerstenter(ForgetPasswordView forgetPasswordView){
        this.forgetPasswordView=forgetPasswordView;
    }

    public void goCommint(){
        if(forgetPasswordView.getPhone().isEmpty()){
            forgetPasswordView.toLoginActivity("手机号不能为空");
        }else if (!StringUtils.isMobile(forgetPasswordView.getPhone())){
            forgetPasswordView.toLoginActivity("手机号不正确");
        }else if (forgetPasswordView.getCode().isEmpty()){
            forgetPasswordView.toLoginActivity("验证码不能为空");
        } else if(forgetPasswordView.getPwd().isEmpty()){
            forgetPasswordView.toLoginActivity("密码不能为空");
        }else{
            //网络访问
        }

    }
}
