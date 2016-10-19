package com.baohua.databingdemo.model;

/**
 * @Author yaobaohua
 * @CreatedTime 2016/10/20 00：03
 * @DESC :
 */

public class Worker {

    private String name;
    private String num;
    private boolean isLeader;

    public Worker(String name, String num, boolean isLeader) {
        this.name = name;
        this.num = num;
        this.isLeader = isLeader;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }
}
