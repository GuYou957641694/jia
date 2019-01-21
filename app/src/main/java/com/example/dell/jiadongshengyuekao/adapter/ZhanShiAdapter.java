package com.example.dell.jiadongshengyuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.jiadongshengyuekao.bean.ZhanShi;

import java.util.List;

public class ZhanShiAdapter extends RecyclerView.Adapter<ZhanShiAdapter.Hodler> {

    private Context context;
    private List<ZhanShi.DataBean> list;

    public ZhanShiAdapter(Context context, List<ZhanShi.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<ZhanShi.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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

        public Hodler(View itemView) {
            super(itemView);
        }
    }
}
