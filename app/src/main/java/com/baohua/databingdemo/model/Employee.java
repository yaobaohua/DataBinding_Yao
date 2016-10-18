package com.baohua.databingdemo.model;

/**
 * Created by yaobaohua on 2016/10/18 14:35
 * Contact me :2584899504@qq.com
 * DESC :
 */

public class Employee {

    private String name;
    private String positionId;
    private int age;
    private boolean isFired;

    public Employee(String name, int age, String positionId) {
        this.name = name;
        this.positionId = positionId;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }
}
