package com.wong.topencv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wong.topencv.bean.ItemBean;

/**
 * @author WongKyunban
 * description
 * created at 2018-09-30 上午11:43
 * @version 1.0
 */
public class ItemViewHolder<T extends ItemBean> extends RecyclerView.ViewHolder {

    TextView mTvTitle;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(T bean){
        mTvTitle = (TextView)itemView.findViewById(R.id.tv_title);
        mTvTitle.setText(bean.getTitle());
    }
}
