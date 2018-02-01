package com.yuk.bean;

/**
 * Created by 浴缸 on 2017/12/19.
 */
public class Message {
    private int id;
    private String name;
    private double money;

    public Message(){
    }

    public Message(String name,double money){
        this.name = name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
