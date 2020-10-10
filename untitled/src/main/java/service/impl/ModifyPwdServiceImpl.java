package service.impl;

import dao.ICommonDao;
import dao.impl.CommonDaoImpl;
import service.IModifyPwdService;

import java.sql.SQLException;

public class ModifyPwdServiceImpl implements IModifyPwdService {

    @Override
    public int modifyPwd(String newPassword, String username, String password) throws SQLException {
        ICommonDao dao = new CommonDaoImpl();
        return dao.updatePwd(newPassword, username, password);
    }
}
