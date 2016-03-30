package com.app.sxgwma.presenter;


import com.app.sxgwma.model.LoginModel;
import com.app.sxgwma.view.ILoginView;

/**
 * Created by admin on 2016/3/14.
 */
public class LoginPersenter {
    private ILoginView loginView;
    private LoginModel model;
    public LoginPersenter(ILoginView loginView){
        this.loginView=loginView;
        model=new LoginModel();
    }

    public LoginModel getModel() {
        return model;
    }
    /**
     * 注册
     * */
    public void login(){
        //姓名不为空
        if(loginView.getUserName().isEmpty()){
            loginView.toLoginActivity("真实姓名不能为空");
        }else if(loginView.getUserPwd().isEmpty()){
            loginView.toLoginActivity("密码不能为空");
        }
        else{
            model.goLogin(loginView.getUserName(), loginView.getUserPwd());
        }
    }

}
