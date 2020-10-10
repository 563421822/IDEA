package service;

import java.sql.SQLException;

public interface IAddService {
    int add(String name, String password, String phone, String address) throws SQLException;

}
