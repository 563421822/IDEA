package com.wyl.entity;

public class TBank {
    private String account;
    private String password;
    private double balance;

    @Override
    public String toString() {
        return "TBank{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
