package service;

import java.sql.SQLException;

public interface IRegisterService {
    int register(String username, String password, String gender, String birthday, String hobbies, String city) throws SQLException;
}
