package com.bwei.wsq.mvpdl.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwei.wsq.mvpdl.R;
import com.bwei.wsq.mvpdl.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by WSQ on 2018/1/9 0009.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<ShowBean.TuijianBean.ListBean> list;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;
    //跳转到详情页的操作
    public interface OnItemClickListener{
        void onItem(String str);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public MyAdapter(Context context, List<ShowBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.liebiao_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final ShowBean.TuijianBean.ListBean listBean = list.get(position);
        myViewHolder.sim.setImageURI(listBean.getImages());
        myViewHolder.tv1.setText(listBean.getTitle());

        //跳转到详情页
        myViewHolder.liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pid = listBean.getPid();
                onItemClickListener.onItem(pid+"");
            }
        });

    }

    @Override
    public int getItemCount() {
        if (list == null){
            return 0;
        }
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public SimpleDraweeView sim;
        public TextView tv1;
        private final LinearLayout liner;

        public MyViewHolder(View itemView) {
            super(itemView);
            liner = itemView.findViewById(R.id.liner);
            sim = itemView.findViewById(R.id.sim);
            tv1 = itemView.findViewById(R.id.tv1);

        }
    }
}
