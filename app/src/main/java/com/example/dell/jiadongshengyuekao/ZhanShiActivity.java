package com.example.dell.jiadongshengyuekao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.dell.jiadongshengyuekao.adapter.ZhanShiAdapter;
import com.example.dell.jiadongshengyuekao.bean.ZhanShi;
import com.example.dell.jiadongshengyuekao.iview.IView;
import com.example.dell.jiadongshengyuekao.presnter.PresnterImp;
import com.example.dell.jiadongshengyuekao.utli.Contacts;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhanShiActivity extends AppCompatActivity implements IView {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private PresnterImp presnterImp;
    private ZhanShiAdapter zhanShiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_zhan_shi);
        ButterKnife.bind(this);
        inView();
    }

    private void inView() {
        zhanShiAdapter = new ZhanShiAdapter(this, null);
        presnterImp = new PresnterImp(this);
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Object> headmap = new HashMap<>();
        presnterImp.setData(Contacts.BASE_BANNER, map, headmap, ZhanShi.class);
    }

    @Override
    public void Success(Object data) {
        if (data instanceof ZhanShi) {
            ZhanShi zhanShi = (ZhanShi) data;
            zhanShiAdapter.setList(zhanShi.getData());
            recyclerview.setAdapter(zhanShiAdapter);
        }
    }
}
