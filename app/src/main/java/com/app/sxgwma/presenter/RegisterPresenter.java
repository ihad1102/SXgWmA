package com.app.sxgwma.presenter;

import com.app.sxgwma.model.RegisterModel;
import com.app.sxgwma.util.IDCardUtil;
import com.app.sxgwma.util.StringUtils;
import com.app.sxgwma.view.IRegisterView;

import java.text.ParseException;

/**
 * Created by admin on 2016/3/11.
 */
public class RegisterPresenter {
    private IRegisterView registerView;
    private boolean isID;
    private RegisterModel model;

    public RegisterModel getModel() {
        return model;
    }

    public RegisterPresenter(IRegisterView registerView){
            this.registerView=registerView;
            model=new RegisterModel();
    }
    /**
     * 注册
     * */
    public void register(){
       //显示加载
        try {
         isID= IDCardUtil.IDCardValidate(registerView.getIdCardNumber().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        RequestParams params=new RequestParams();
        //姓名不为空
        if(registerView.getRealName().isEmpty()){
            registerView.toRegisterActivity("真实姓名不能为空");
        }else if(registerView.getSetPassword().isEmpty()){
            registerView.toRegisterActivity("密码不能为空");
        }else if (registerView.getConfirmPassword().isEmpty()){
            registerView.toRegisterActivity("密码不能为空");
        }else if (!registerView.getSetPassword().equals(registerView.getConfirmPassword())){
            registerView.toRegisterActivity("两次输入密码不一致");
        }else if(registerView.getEmail().isEmpty()){
            registerView.toRegisterActivity("邮箱不能为空");
        }else if(!StringUtils.isEmail(registerView.getEmail())){
            registerView.toRegisterActivity("邮箱格式不正确");
        }else if (registerView.getPhone().isEmpty()){
            registerView.toRegisterActivity("手机号不能为空");
        }else if (!StringUtils.isMobile(registerView.getPhone())){
            registerView.toRegisterActivity("手机号不正确");
        }else if(registerView.getIdCardNumber().isEmpty()){
            registerView.toRegisterActivity("身份证号不能为空");
        }else if(!isID){
            registerView.toRegisterActivity("身份证号不正确");
            }
       else if(registerView.getCode().isEmpty()){
            registerView.toRegisterActivity("验证码不能为空");
        }else if(!StringUtils.exChangeUpperCase(registerView.getCode()).
                equals(StringUtils.exChangeUpperCase(registerView.getIvCode()))){
            registerView.toRegisterActivity("验证码输入不正确");
        }else if(!registerView.getCheckBox()){
            registerView.toRegisterActivity("你还未选择框");
        }
        else{
//            params.add("realname", registerView.getRealName());
//            params.add("realpass", MD5.get32MD5(registerView.getSetPassword()));
//            params.add("email", registerView.getEmail());
//            params.add("phone", registerView.getPhone());
//            params.add("idcard", registerView.getIdCardNumber());
//            HttpUtil.get(AppConfig.REGISTER, params, new AsyncHttpResponseHandler() {
//                @Override
//                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                    //关闭加载
//                    String result = new String(responseBody);
//                    registerView.toRegisterActivity(result);
//                    Log.i("打印信息:", result);
//                }
//
//                @Override
//                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                    //显示失败信息
//                    String result = new String(responseBody);
//                    registerView.toRegisterActivity(result);
//                }
//            });
            registerView.showLoading();
            model.goRegister(registerView.getRealName(),registerView.getSetPassword(),
                    registerView.getEmail(),registerView.getPhone(),registerView.getIdCardNumber(),registerView);
        }
    }
}
