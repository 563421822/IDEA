package dao.impl;

import dao.IDao;
import entity.ContactsEntity;
import utils.DBUtils;
import utils.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoImpl implements IDao {
    final ArrayList<ContactsEntity> list = new ArrayList<>();

    /**
     * 通过用户名和密码查询用户是否存在
     *
     * @param name
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public int query(String name, String password) throws SQLException {
        String sql = "SELECT count(`name`) FROM t_contacts WHERE `name` =? AND `password` =?";
        ResultSet query = DBUtils.query(sql, name, password);
        if (query.next()) {
            return query.getInt(1);
        }
        return 0;
    }

    /**
     * 分页查询所有信息
     *
     * @param page
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<ContactsEntity> queryAll(Page page) throws SQLException {
        String sql = "SELECT * FROM t_contacts LIMIT ?,?";
        ResultSet query = DBUtils.query(sql, page.getStartCount(), page.getPageSize());
        while (query.next()) {
            ContactsEntity entity = new ContactsEntity();
            entity.setName(query.getString("name"));
            entity.setPhone(query.getString("phone"));
            entity.setAddress(query.getString("address"));
            list.add(entity);
        }
        return list;
    }

    /**
     * 查询单条记录
     *
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<ContactsEntity> queryDetail(String name) throws SQLException {
        String sql = "SELECT `name`, `password`, phone, address FROM t_contacts WHERE `name` =?";
        ResultSet query = DBUtils.query(sql, name);
        if (query.next()) {
            ContactsEntity entity = new ContactsEntity();
            entity.setName(query.getString("name"));
            entity.setPassword(query.getString("password"));
            entity.setPhone(query.getString("phone"));
            entity.setAddress(query.getString("address"));
            list.add(entity);
        }
        return list;
    }

    /**
     * 执行删除操作
     *
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public int delete(String name) throws SQLException {
        String sql = "DELETE FROM t_contacts WHERE NAME =?";
        return DBUtils.update(sql, name);
    }

    /**
     * 执行添加操作
     *
     * @param name
     * @param password
     * @param phone
     * @param address
     * @return
     * @throws SQLException
     */
    @Override
    public int add(String name, String password, String phone, String address) throws SQLException {
        String sql = "INSERT INTO t_contacts ( name, password, phone, address ) VALUES (?,?,?,?)";
        return DBUtils.update(sql, name, password, phone, address);
    }

    /**
     * 执行更改操作
     *
     * @param name
     * @param phone
     * @param address
     * @return
     * @throws SQLException
     */
    @Override
    public int update(String name, String phone, String address) throws SQLException {
        String sql = "UPDATE t_contacts SET phone =?, address =? WHERE `name` =?";
        return DBUtils.update(sql, phone, address, name);
    }

    /**
     * 查询总记录数
     *
     * @return
     * @throws SQLException
     */
    @Override
    public int queryCount() throws SQLException {
        String sql = "SELECT count(id) FROM t_contacts";
        ResultSet query = DBUtils.query(sql);
        if (query.next()) {
//            获取数字类型的第一行
            return query.getInt(1);
        }
        return 0;
    }
}
