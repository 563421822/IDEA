package dao;

import entity.ContactsEntity;
import utils.Page;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDao {
    int query(String name, String password) throws SQLException;

    ArrayList<ContactsEntity> queryAll(Page page) throws SQLException;

    ArrayList<ContactsEntity> queryDetail(String name) throws SQLException;

    int delete(String name) throws SQLException;

    int add(String name, String password, String phone, String address) throws SQLException;

    int update(String name, String phone, String address) throws SQLException;

    int queryCount() throws SQLException;
}
