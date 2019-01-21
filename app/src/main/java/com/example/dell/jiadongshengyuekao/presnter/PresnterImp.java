package com.example.dell.jiadongshengyuekao.presnter;


import com.example.dell.jiadongshengyuekao.callback.CallBack;
import com.example.dell.jiadongshengyuekao.iview.IView;
import com.example.dell.jiadongshengyuekao.model.ModelImp;

import java.util.HashMap;

public class PresnterImp implements Presenter {

    private ModelImp modelImp;
    private IView iView;

    public PresnterImp(IView iView) {
        modelImp = new ModelImp();
        this.iView = iView;
    }

    @Override
    public void setData(String url, HashMap<String, String> map, HashMap<String, Object> headmap, Class clazz) {
        modelImp.getData(url, map, headmap, clazz, new CallBack() {
            @Override
            public void setData(Object data) {
                iView.Success(data);
            }
        });
    }
}
