package com.example.dell.jiadongshengyuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.jiadongshengyuekao.bean.ZhanShi;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Hodler> {

    private Context context;
    private List<ZhanShi.DataBean> list;

    public MyAdapter(Context context, List<ZhanShi.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View view = View.inflate(R.layout.list_item);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Hodler holder, int position) {




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Hodler extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView text1, text2;

        public Hodler(View itemView) {
            super(itemView);
        }
    }
}
