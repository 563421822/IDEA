package com.wyl.zy.dao.impl;

import com.wyl.zy.dao.IGameDao;
import com.wyl.zy.entity.GameEntity;
import com.wyl.zy.utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameDaoImpl implements IGameDao {

    @Override
    public int updateByAccount(String account, double sum) throws SQLException {
        String sql = "UPDATE game_account SET amoney = amoney + (?) WHERE aname =?";
//        玩家账号加钱
        return DBUtils.update(sql, sum, account);

    }

    //    查询道具表中所有信息
    @Override
    public ArrayList<GameEntity> queryAllField() throws SQLException {

        ArrayList<GameEntity> list = new ArrayList<>();

        String sql = "SELECT * FROM game_props";
        ResultSet query = DBUtils.query(sql);


        while (query.next()) {

            GameEntity entity = new GameEntity();
            entity.setPid(query.getInt("pid"));
            entity.setPaname(query.getString("pname"));
            entity.setPrice(query.getDouble("price"));
//            将对象存入集合
            list.add(entity);
        }
        return list;
    }

    //查询道具价格
    @Override
    public double queryPrice(int chosenId) throws SQLException {
        String sql = "SELECT price FROM game_props WHERE pid =?";
        ResultSet query = DBUtils.query(sql, chosenId);

        return query.getDouble("price");

    }

    //更新所有账户
    @Override
    public boolean updateAllAcount(double price, int num) throws SQLException {
        String sql = "UPDATE game_account SET amoney = amoney + (?) WHERE aname =?";

        //     npc账户加钱
        int add = DBUtils.update(sql, price * num, "npc");

// 玩家账户减钱
        int minus = DBUtils.update(sql, (-price) * num, "wanjia");
        return minus == 1 && add == 1;


    }

    //查询自己的余额
    @Override
    public double queryOwn() throws SQLException {
        String sql = "SELECT amoney FROM game_account WHERE aname = 'wanjia'";
        ResultSet query = DBUtils.query(sql);
        if (query.next()) {
            return query.getDouble("amoney");
        }
        return 0;
    }
}
