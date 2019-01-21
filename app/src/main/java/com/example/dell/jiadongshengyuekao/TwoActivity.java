package com.example.dell.jiadongshengyuekao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.jiadongshengyuekao.bean.Shop;
import com.example.dell.jiadongshengyuekao.iview.IView;
import com.example.dell.jiadongshengyuekao.presnter.PresnterImp;
import com.example.dell.jiadongshengyuekao.utli.Contacts;
import com.stx.xhb.xbanner.XBanner;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TwoActivity extends AppCompatActivity implements IView {


    @BindView(R.id.goumai)
    Button goumai;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.text1)
    TextView text1;
    @BindView(R.id.prci)
    TextView prci;
    private PresnterImp presnterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);
        inView();
    }

    private void inView() {
        presnterImp = new PresnterImp(this);
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Object> headmap = new HashMap<>();
        presnterImp.setData(Contacts.BASE_SHOP, map, headmap, Shop.class);
    }

    @Override
    public void Success(Object data) {
        Shop shop = (Shop) data;
        Shop.DataBean data1 = shop.getData();
        //Glide.with(this).load().into(img);
        text1.setText(data1.getTitle());
        prci.setText("¥" + data1.getPrice() + "");
    }

    @OnClick(R.id.goumai)
    public void onViewClicked() {
    }
}
