package service;

import java.sql.SQLException;

public interface IEditService {
    int edit(String name, String phone, String address) throws SQLException;
}
