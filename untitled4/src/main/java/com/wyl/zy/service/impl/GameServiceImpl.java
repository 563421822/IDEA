package com.wyl.zy.service.impl;

import com.wyl.zy.dao.IGameDao;
import com.wyl.zy.dao.impl.GameDaoImpl;
import com.wyl.zy.entity.GameEntity;
import com.wyl.zy.service.IGameService;
import com.wyl.zy.utils.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;

public class GameServiceImpl implements IGameService {
    IGameDao dao = new GameDaoImpl();

    //    充值
    @Override
    public boolean topUp(String account, double sum) throws SQLException {

        int result = dao.updateByAccount(account, sum);
        return result > 0;
    }

    /**
     * 展示所有道具
     *
     * @return
     */
    @Override
    public ArrayList<GameEntity> showAll() throws SQLException {
        return dao.queryAllField();
    }

    //购买道具类
    @Override
    public boolean buy(int chosenId, int num) throws Exception {
//        先把道具价格查出来
        double price = dao.queryPrice(chosenId);
        double own = dao.queryOwn();
        //开启手动事务
        DBUtils.connection.setAutoCommit(false);
        try {

//        执行操作
            dao.updateAllAcount(price, num);

            if (own >= price) {
                DBUtils.connection.commit();
                return true;
            }

        } catch (Exception e) {
            System.out.println("扣款失败,已回滚.");

            DBUtils.connection.rollback();

        } finally {
            DBUtils.close(DBUtils.resultSet, DBUtils.preparedStatement, DBUtils.connection);
        }

        return false;
    }
}
