package com.wyl.dao.impl;

import com.wyl.dao.IBankDao;
import com.wyl.utils.DBUtils;

import java.sql.ResultSet;

public class BankDaoImpl implements IBankDao {


    //登陆操作
    @Override
    public int queryByInfo(String account, String password) throws Exception {
        String sql = "SELECT COUNT(account) FROM t_bank WHERE account=? AND password=?";
        ResultSet query = DBUtils.query(sql, account, password);
        if (query.next()) {
            return query.getInt(1);
        }
        return 0;
    }

    //查询收款人账户是否存在
    @Override
    public int queryByAcc(String transTo) throws Exception {
        String sql = "SELECT account FROM t_bank WHERE account =?";
        ResultSet query = DBUtils.query(sql, transTo);
        if (query.next()) {
            return 1;
        }
        return 0;
    }

    //查询转出金额是否充足
    @Override
    public double queryBalanceField(String transAmount) throws Exception {
        String sql = "SELECT balance FROM t_bank WHERE account =?";
        ResultSet query = DBUtils.query(sql, transAmount);
        if (query.next()) {
            return query.getDouble("balance");
        }
        return 0.0;
    }

    /**
     * 转账功能方法
     *
     * @param account
     * @param transTo
     * @param transAmount
     * @return
     * @throws Exception
     */
    @Override
    public int transfer(String account, String transTo, double transAmount) throws Exception {
        String sql = "UPDATE t_bank SET balance = balance + (?) WHERE account = ?";
//        扣款
        int minus = DBUtils.update(sql, -transAmount, account);
//        入账
        int add = DBUtils.update(sql, transAmount, transTo);
        if (minus == 1 && add == 1) {
            return 1;
        }
        return 0;
    }
}
