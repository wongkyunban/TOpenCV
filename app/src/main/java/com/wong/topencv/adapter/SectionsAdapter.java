package com.wong.topencv.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wong.topencv.ItemViewHolder;
import com.wong.topencv.R;
import com.wong.topencv.bean.ItemBean;
import com.wong.topencv.inter.OnItemViewClickListener;

import java.util.List;

/**
 * @author WongKyunban
 * description
 * created at 2018-09-30 上午11:38
 * @version 1.0
 */
public class SectionsAdapter<T extends ItemBean> extends RecyclerView.Adapter {


    List<T> list;

    public SectionsAdapter(List<T> t){
        this.list = t;
    }




    private OnItemViewClickListener listener;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_layout,viewGroup,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {


        ((ItemViewHolder)viewHolder).bind(list.get(i));
        ((ItemViewHolder)viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClick(list.get(i));
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setListener(OnItemViewClickListener listener) {
        this.listener = listener;
    }
}
