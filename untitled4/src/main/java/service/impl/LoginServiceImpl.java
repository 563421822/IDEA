package service.impl;

import dao.IDao;
import dao.impl.DaoImpl;
import service.ILoginService;

import java.sql.SQLException;

public class LoginServiceImpl implements ILoginService {
    @Override
    public int login(String name, String password) throws SQLException {
        IDao IDao = new DaoImpl();
        return IDao.query(name, password);
    }
}
