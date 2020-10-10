package dao;

import entity.Entity;
import utils.Page;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICommonDao {
    int queryByInfo(String username, String password, String role) throws Exception;

    int insert(String username, String password, String gender, String birthday, String hobbies, String city) throws SQLException;

    ArrayList<Entity> queryAll(Page page) throws SQLException;

    int updatePwd(String newPassword, String username, String password) throws SQLException;

    ArrayList<Entity> QueryByName(String name) throws SQLException;

    int queryCount() throws SQLException;
}
