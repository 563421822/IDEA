package com.wyl.zy.entity;

public class GameEntity {
    private int pid;
    private String paname;
    private double price;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPaname() {
        return paname;
    }

    public void setPaname(String paname) {
        this.paname = paname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GameEntity{" +
                "pid=" + pid +
                ", paname=" + paname +
                ", price=" + price +
                '}';
    }
}
