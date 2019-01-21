package com.example.dell.jiadongshengyuekao.model;

import android.util.Log;

import com.example.dell.jiadongshengyuekao.bean.Home;
import com.example.dell.jiadongshengyuekao.bean.Shop;
import com.example.dell.jiadongshengyuekao.callback.CallBack;
import com.example.dell.jiadongshengyuekao.utli.RetrofitUtils;
import com.google.gson.Gson;


import java.util.HashMap;

import static android.support.constraint.Constraints.TAG;

public class ModelImp implements Model {
    @Override
    public void getData(String url, HashMap<String,String> map, HashMap<String,Object> headmap, final Class clazz, final CallBack callBack) {
        if (clazz == Home.class) {
            RetrofitUtils.getInstence().get(url, map,headmap,new RetrofitUtils.HttpListener() {
                @Override
                public void onSuccess(String jsonStr) {
                    Gson gson = new Gson();
                    Object o = gson.fromJson(jsonStr, clazz);
                    callBack.setData(o);
                }

                @Override
                public void onError(String error) {
                    Log.d(TAG, "onError: 123123123123");
                }
            });
        } else if (clazz == Shop.class) {
            RetrofitUtils.getInstence().get(url,map, headmap,new RetrofitUtils.HttpListener() {
                @Override
                public void onSuccess(String jsonStr) {
                    Gson gson = new Gson();
                    Object o = gson.fromJson(jsonStr, clazz);
                    callBack.setData(o);
                }

                @Override
                public void onError(String error) {

                }
            });
        }
    }
}
