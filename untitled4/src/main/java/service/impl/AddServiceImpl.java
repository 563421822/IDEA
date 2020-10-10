package service.impl;

import dao.IDao;
import dao.impl.DaoImpl;
import service.IAddService;

import java.sql.SQLException;

public class AddServiceImpl implements IAddService {
    @Override
    public int add(String name, String password, String phone, String address) throws SQLException {
        IDao dao = new DaoImpl();
        return dao.add(name, password, phone, address);
    }
}
