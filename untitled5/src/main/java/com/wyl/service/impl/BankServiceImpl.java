package com.wyl.service.impl;

import com.wyl.dao.IBankDao;
import com.wyl.dao.impl.BankDaoImpl;
import com.wyl.service.IBankService;
import com.wyl.utils.DBUtils;

import java.sql.Connection;

public class BankServiceImpl implements IBankService {
    //登录方法
    @Override
    public boolean login(String account, String password) throws Exception {
        IBankDao obj = new BankDaoImpl();
        int result = obj.queryByInfo(account, password);
        return result > 0;
    }

    //判断收款人是否存在
    @Override
    public boolean ifExist(String transTo) throws Exception {
        IBankDao obj = new BankDaoImpl();
        int result = obj.queryByAcc(transTo);
//        如果查询结果大于0,说明收款人存在
        return result > 0;
    }

    //判断余额是否充足
    @Override
    public double whetherLess(String transAmount) throws Exception {
        IBankDao obj = new BankDaoImpl();
        return obj.queryBalanceField(transAmount);
    }

    //转账实现方法
    @Override
    public boolean transfer(String account, String transTo, double transAmount) throws Exception {
        IBankDao obj = new BankDaoImpl();
//        声明变量接收
        Connection connection = DBUtils.getConnection();
//        开启手动事务
        connection.setAutoCommit(false);
        try {

            //        业务层调用dao层更新账户字段的方法
            int transfer = obj.transfer(account, transTo, transAmount);
            //int ice = 10 / 0;
//        如果减钱和加钱返回的都是1则返回true;
            if (transfer == 1) {
//                提交事务
                connection.commit();
                return true;
            }

        } catch (Exception e) {

            connection.rollback();
            System.out.println("出现异常,连接对象内存地址:" + connection);

        } finally {
//           关闭连接对象
            DBUtils.close(DBUtils.resultSet, DBUtils.preparedStatement, connection);
        }
        return false;
    }
}

