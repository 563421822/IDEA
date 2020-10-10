package com.wyl.dao;

public interface IBankDao {
    //    登陆操作
    int queryByInfo(String account, String password) throws Exception;

    //    查询是否存在收款人账户
    int queryByAcc(String transTo) throws Exception;

    //    查询所拥有的余额是否充足
    double queryBalanceField(String transAmount) throws Exception;


    //int transferMinus(String account, double transAmount);
//service转账的方法
    int transfer(String account, String transTo, double transAmount) throws Exception;
}
