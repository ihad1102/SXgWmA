package com.app.sxgwma.base;

import android.content.Context;

import com.app.sxgwma.util.HttpCallBackUtil;

import java.util.ArrayList;

/**
 * Created by admin on 2016/3/14.
 */
public class BaseModel implements HttpCallBackUtil {
    protected ArrayList<HttpCallBackUtil> businessResponseArrayList = new ArrayList<HttpCallBackUtil>();
    protected static Context mContext;

    public BaseModel() {

    }
    public void addResponseListener(HttpCallBackUtil listener){
        if (!businessResponseArrayList.contains(listener)) {
            businessResponseArrayList.add(listener);
        }
    }

    public void removeResponseListener(HttpCallBackUtil listener) {
        businessResponseArrayList.remove(listener);
    }
    @Override
    public void onCallBackData(String url, String content, boolean iscontent) {
        for (HttpCallBackUtil iterable_element : businessResponseArrayList) {
            iterable_element.onCallBackData(url, content,iscontent);
        }
    }
}
