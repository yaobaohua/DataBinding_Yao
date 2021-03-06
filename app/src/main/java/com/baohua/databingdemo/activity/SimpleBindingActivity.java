package com.baohua.databingdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.baohua.databingdemo.R;
import com.baohua.databingdemo.databinding.ActivityMainBinding;
import com.baohua.databingdemo.databinding.ActivitySimpleBinding;
import com.baohua.databingdemo.model.Employee;

public class SimpleBindingActivity extends AppCompatActivity {


    ActivitySimpleBinding binding;

    Employee employee = new Employee("保华", 19, "999");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple);
        binding.setEmployee(employee);

        //两种方式设置dataBinding的变量
//        binding.setVariable(com.baohua.databingdemo.BR.presenter, new Presenter());
        binding.setPresenter(new Presenter());


        //viewstub
        binding.idViewStub.getViewStub().inflate();
    }


    public class Presenter {
        //事件的方法引用（要求比较严格，方法名必须与原ui的事件监听一致）
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            employee.setName(s + "");
            employee.setFired(!employee.isFired());
//            binding.setEmployee(employee);
        }

        //事件的方法引用（要求比较严格，方法名必须与原ui的事件监听一致）
        public void onClick(View view) {
            Toast.makeText(SimpleBindingActivity.this, "颠倒了", Toast.LENGTH_LONG).show();
        }

        //事件的监听，可以从xml传回值来
        public void onClickListenerBinding(Employee employee) {
            Toast.makeText(SimpleBindingActivity.this, employee.getAge() + "", Toast.LENGTH_LONG).show();
        }
    }
}
