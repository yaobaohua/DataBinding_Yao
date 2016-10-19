package com.baohua.databingdemo.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.baohua.databingdemo.R;
import com.baohua.databingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPresenter(new Presenter());
    }


    public class Presenter {
        //事件的监听，可以从xml传回值来
        public void onClickSimpleListenerBinding() {
            startActivity(new Intent(MainActivity.this,SimpleBindingActivity.class));
        }
        public void onClickListListenerBinding() {
            startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));
        }
    }
}
