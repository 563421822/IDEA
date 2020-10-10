package dao.impl;

import dao.ICommonDao;
import entity.Entity;
import utils.DBUtils;
import utils.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommonDaoImpl implements ICommonDao {
    @Override
    public int queryByInfo(String username, String password, String role) throws Exception {
        String sql = "SELECT count(username) FROM t_user WHERE username = ? AND password = ? AND role = ?";
        ResultSet query = DBUtils.query(sql, username, password, role);
        if (query.next()) {
            return query.getInt(1);
        }
        return 0;
    }

    /**
     * 插入记录
     *
     * @param username
     * @param password
     * @param gender
     * @param birthday
     * @param hobbies
     * @param city
     * @return
     * @throws SQLException
     */
    @Override
    public int insert(String username, String password, String gender, String birthday, String hobbies, String city) throws SQLException {
        String sql = "INSERT INTO t_user ( username, PASSWORD, gender, birthday, hobby, city ) VALUES (?,?,?,?,?,?)";
        return DBUtils.update(sql, username, password, gender, birthday, hobbies, city);
    }

    /**
     * 分页查询所有记录
     *
     * @param page
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Entity> queryAll(Page page) throws SQLException {
        String sql = "SELECT * FROM t_user LIMIT ?, ?";
        ArrayList<Entity> list = new ArrayList<>();
        ResultSet query = DBUtils.query(sql, page.getStart(), page.getPageSize());

        while (query.next()) {
//            每次声明一个新的变量防止覆盖
            Entity entity = new Entity();
//将字段存入对象
            entity.setUsername(query.getString("username"));
            entity.setPassword(query.getString("password"));
            entity.setGender(query.getString("gender"));
            entity.setBirthday(query.getString("birthday"));
            entity.setHobby(query.getString("hobby"));
            entity.setCity(query.getString("city"));
            list.add(entity);
        }
        return list;
    }

    /**
     * 修改密码
     *
     * @param newPassword
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public int updatePwd(String newPassword, String username, String password) throws SQLException {
        String sql = "UPDATE t_user SET PASSWORD=? WHERE username=? AND PASSWORD=?";
        return DBUtils.update(sql, newPassword, username, password);
    }

    /**
     * 通过名字查询用户信息
     *
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Entity> QueryByName(String name) throws SQLException {
        String sql = "SELECT username, gender, birthday, hobby, city FROM t_user WHERE username =?";
        ArrayList<Entity> list = new ArrayList<>();
        ResultSet query = DBUtils.query(sql, name);
        while (query.next()) {
            Entity entity = new Entity();
            entity.setUsername(query.getString("username"));
            entity.setGender(query.getString("gender"));
            entity.setBirthday(query.getString("birthday"));
            entity.setHobby(query.getString("hobby"));
            entity.setCity(query.getString("city"));
            list.add(entity);
        }
        return list;
    }

    @Override
    public int queryCount() throws SQLException {
        String sql = "SELECT count(username) FROM t_user";
        ResultSet query = DBUtils.query(sql);
        if (query.next()) {
            return query.getInt(1);
        }
        return 0;
    }
}
