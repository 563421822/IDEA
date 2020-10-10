package service;

import java.sql.SQLException;

public interface ILoginService {
    int login(String name, String password) throws SQLException;
}
