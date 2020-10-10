package service.impl;

import dao.ICommonDao;
import dao.impl.CommonDaoImpl;
import service.IRegisterService;

import java.sql.SQLException;


public class RegisterServiceImpl implements IRegisterService {

    @Override
    public int register(String username, String password, String gender, String birthday, String hobbies, String city) throws SQLException {
        ICommonDao dao = new CommonDaoImpl();
        return dao.insert(username, password, gender, birthday, hobbies, city);
    }
}
