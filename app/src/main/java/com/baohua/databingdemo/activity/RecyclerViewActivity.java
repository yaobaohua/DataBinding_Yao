package com.baohua.databingdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.baohua.databingdemo.R;

import com.baohua.databingdemo.adapter.WorkerAdapter;
import com.baohua.databingdemo.databinding.ActivityListBinding;
import com.baohua.databingdemo.model.Worker;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yaobaohua
 * @CreatedTime 2016/10/19 23：07
 * @DESC :
 */

public class RecyclerViewActivity extends AppCompatActivity {
    ActivityListBinding mBinding;
    WorkerAdapter adapter;
    private List<Worker> workers;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_list);
        mBinding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.setPresenter(new Presenter());
        workers=new ArrayList<>();
        workers.add(new Worker("lisi","22",true));
        workers.add(new Worker("wangwu","233",false));
        workers.add(new Worker("yao","2452",false));
        workers.add(new Worker("bao","322",true));
        adapter=new WorkerAdapter(this);
        mBinding.recycleView.setAdapter(adapter);
        adapter.setOnRecycleItemClickListener(new WorkerAdapter.OnRecycleItemClickListener() {
            @Override
            public void onRecycleItemClick(Worker worker) {
                Toast.makeText(RecyclerViewActivity.this,worker.getName(),Toast.LENGTH_LONG).show();
            }
        });
        adapter.addAllItem(workers);
    }

    public class Presenter{
        public void onClickAddItem(View view){
            adapter.addOneItem(new Worker("zhao","2323",true));
        }


        public void onClickRemoveItem(View view){
            adapter.removewItem();

        }
    }
}
