package com.baohua.databingdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baohua.databingdemo.R;
import com.baohua.databingdemo.model.Employee;
import com.baohua.databingdemo.model.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author yaobaohua
 * @CreatedTime 2016/10/19 23：54
 * @DESC :
 */

public class WorkerAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    private List<Worker> mDatas=new ArrayList<>();
    private static final int VIEW_TYPE_NORMAL = 1;
    private static final int VIEW_TYPE_BIG = 2;

    private Context context;
    private static LayoutInflater mLayoutInflate;

    public void setOnRecycleItemClickListener(OnRecycleItemClickListener onRecycleItemClickListener) {
        this.onRecycleItemClickListener = onRecycleItemClickListener;
    }

    private OnRecycleItemClickListener onRecycleItemClickListener;

    public interface OnRecycleItemClickListener {
        void onRecycleItemClick(Worker worker);
    }

    public WorkerAdapter(Context context) {
        this.context = context;
        mLayoutInflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemViewType(int position) {
        if (mDatas.get(position).isLeader()) {
            return VIEW_TYPE_BIG;
        } else {
            return VIEW_TYPE_NORMAL;
        }
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if (viewType == VIEW_TYPE_NORMAL) {
            binding = DataBindingUtil.inflate(mLayoutInflate, R.layout.item_recyler_view_normal, parent, false);
        } else {
            binding = DataBindingUtil.inflate(mLayoutInflate, R.layout.item_recyler_view_big, parent, false);
        }

        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        final Worker worker = mDatas.get(position);
        holder.getmBinding().setVariable(com.baohua.databingdemo.BR.item, worker);
        holder.getmBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRecycleItemClickListener != null) {
                    onRecycleItemClickListener.onRecycleItemClick(worker);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    Random mRandom = new Random(System.currentTimeMillis());

    public void removewItem() {
        int position = mRandom.nextInt(mDatas.size() - 1);
        if (mDatas.size() > 1) {
            mDatas.remove(position);
            notifyItemRemoved(position);
        }
    }


    public void addAllItem(List<Worker> workers) {
        mDatas.addAll(workers);
        notifyDataSetChanged();
    }

    public void addOneItem(Worker worker) {
        int position = mRandom.nextInt(mDatas.size() );
        mDatas.add(position,worker);
        notifyItemInserted(position);

    }


}
