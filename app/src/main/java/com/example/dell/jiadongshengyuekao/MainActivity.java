package com.example.dell.jiadongshengyuekao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dell.jiadongshengyuekao.bean.Banner;
import com.example.dell.jiadongshengyuekao.bean.Home;
import com.example.dell.jiadongshengyuekao.bean.User;
import com.example.dell.jiadongshengyuekao.iview.IView;
import com.example.dell.jiadongshengyuekao.presnter.PresnterImp;
import com.example.dell.jiadongshengyuekao.utli.Contacts;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IView {


    @BindView(R.id.banner)
    XBanner banner;
    private PresnterImp presnterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        inView();
    }

    private void inView() {
        presnterImp = new PresnterImp(this);
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Object> headmap = new HashMap<>();
        presnterImp.setData(Contacts.BASE_HOME, map, headmap, Home.class);
    }

    @Override
    public void Success(Object data) {
        if (data instanceof Home) {
            Home home = (Home) data;
            final Home.DataBean data1 = home.getData();
            for (int i = 0; i < data1.getBanner().size(); i++) {
                banner.setData(data1.getBanner(), null);
                banner.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(MainActivity.this).load(data1.getBanner().get(position).getIcon()).into((ImageView) view);
                    }
                });
                banner.setPageTransformer(Transformer.Default);
            }
        }

    }
}
