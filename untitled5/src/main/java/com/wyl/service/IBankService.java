package com.wyl.service;

public interface IBankService {
    //    登录接口
    boolean login(String account, String password) throws Exception;

    //查询收款人是否存在
    boolean ifExist(String transTo) throws Exception;

    //查询卡内余额
    double whetherLess(String transAmount) throws Exception;

    boolean transfer(String account, String transTo, double transAmount) throws Exception;
}
