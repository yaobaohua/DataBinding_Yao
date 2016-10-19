package com.baohua.databingdemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayMap;

import com.baohua.databingdemo.BR;

/**
 * Created by yaobaohua on 2016/10/18 14:35
 * Contact me :2584899504@qq.com
 * DESC :
 */

public class Employee extends BaseObservable {

    private String name;
    private String positionId;
    private int age;
    private boolean Fired;

    public ObservableArrayMap<String ,String> mapWord=new ObservableArrayMap<>();

    public Employee(String name, int age, String positionId) {
        this.name = name;
        this.positionId = positionId;
        this.age = age;
        mapWord.put("yao","work");
        mapWord.put("bao","work");
        mapWord.put("hua","work");
    }

    //@bindable的意思是setName的时候，就能及时的更新到UI层面
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Bindable
    public boolean isFired() {
        return Fired;
    }

    public void setFired(boolean fired) {
        Fired = fired;
        notifyChange();
    }
}
