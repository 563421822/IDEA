package com.wyl.utils;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtilsTest {

    @Test
    public void updateTest() throws SQLException {
        String sql = "UPDATE t_bank SET balance = balance + 200.0 WHERE account = 2";
        int update = DBUtils.update(sql);
        System.out.println(update);
    }

    @Test
    public void queryTest() throws Exception {
        String sql = "SELECT * FROM t_bank";
        ResultSet query = DBUtils.query(sql);
        int count = 0;
        while (query.next()) {
            count++;
        }
        System.out.println("数据库中共有" + count + "条数据");

    }

    @Test
    public void dataSourceTest() throws SQLException {
        DBUtils.dataSource.getConnection();
    }

}