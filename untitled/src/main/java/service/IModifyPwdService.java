package service;

import java.sql.SQLException;

public interface IModifyPwdService {
    int modifyPwd(String newPassword, String username, String password) throws SQLException;
}
