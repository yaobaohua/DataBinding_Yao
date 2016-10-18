package com.baohua.databingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.baohua.databingdemo.databinding.ActivityMainBinding;
import com.baohua.databingdemo.model.Employee;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    Employee employee = new Employee("保华", 19, "999");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setEmployee(employee);

        //两种方式设置dataBinding的变量
        binding.setVariable(BR.presenter, new Presenter());
//        binding.setPresenter(new Presenter());
    }


    public class Presenter {
        //事件的方法引用（要求比较严格，方法名必须与原ui的事件监听一致）
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            employee.setName(s + "");
            binding.setEmployee(employee);
        }

        //事件的方法引用（要求比较严格，方法名必须与原ui的事件监听一致）
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "颠倒了", Toast.LENGTH_LONG).show();
        }

        //事件的监听，可以从xml传回值来
        public void onClickListenerBinding(Employee employee) {
            Toast.makeText(MainActivity.this, employee.getAge() + "", Toast.LENGTH_LONG).show();
        }
    }
}
