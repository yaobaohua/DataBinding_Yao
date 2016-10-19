package com.baohua.databingdemo.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @Author yaobaohua
 * @CreatedTime 2016/10/19 23：56
 * @DESC :
 */

public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private T mBinding;

    public void setmBinding(T mBinding) {
        this.mBinding = mBinding;
    }

    public T getmBinding() {

        return mBinding;
    }

    public BindingViewHolder(T mBinding) {
        super(mBinding.getRoot());
        this.mBinding=mBinding;
    }
}
