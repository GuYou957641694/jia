package com.example.dell.jiadongshengyuekao.model;

import com.example.dell.jiadongshengyuekao.callback.CallBack;

import java.util.HashMap;


public interface Model {

    void getData(String url, HashMap<String,String> map, HashMap<String,Object> headmap,Class clazz, CallBack callBack);

}
