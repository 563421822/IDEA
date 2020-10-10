package com.wyl.zy.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    //属性常量，创建配置文件对象
    private final static Properties PROP = new Properties();
    //    连接对象
    public static Connection connection = null;
    //    预编译对象
    public static PreparedStatement preparedStatement = null;
    //    结果集对象
    public static ResultSet resultSet = null;
    //创建一个ThreadLocal线程池常量
//    static final ThreadLocal<Connection> TL = new ThreadLocal<Connection>();

    static {
        try {
            //PROP.load(new FileInputStream("config/jdbc.properties"));
            PROP.load(DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            Class.forName(PROP.getProperty("driver"));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获得连接对象的方法,
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(PROP.getProperty("url"), PROP.getProperty("username"), PROP.getProperty("password"));
        }
        return connection;
     /*   Connection connection = TL.get();
        if (connection == null) {
            TL.set(connection);
//            connection = TL.set(connection);
        }
        return conn;*/
    }

    /**
     * 增删改的方法
     */
    public static int update(String sql, Object... args) throws SQLException {
        connection = getConnection();
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        return preparedStatement.executeUpdate();
    }

    /**
     * 查询的方法
     */
    public static ResultSet query(String sql, Object... args) throws SQLException {
        connection = getConnection();
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        return preparedStatement.executeQuery();
    }

    /**
     * 关闭对象的方法
     */
    public static void close(AutoCloseable... objs) throws Exception {
        if (objs != null) {
//            如果动态参数不为空
            for (int i = 0; i < objs.length; i++) {
                if (objs[i] != null) {
                    objs[i].close();
                    System.out.println("第" + i + "个" + objs[i] + "已关闭");
                }
            }
        }
    }
}