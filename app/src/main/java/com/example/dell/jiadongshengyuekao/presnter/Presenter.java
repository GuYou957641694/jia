package com.example.dell.jiadongshengyuekao.presnter;

import java.util.HashMap;

public interface Presenter {

    void setData(String url, HashMap<String,String> map, HashMap<String,Object> headmap,Class clazz);
}
