package service.impl;

import dao.IDao;
import dao.impl.DaoImpl;
import service.IEditService;

import java.sql.SQLException;

public class EditServiceImpl implements IEditService {
    @Override
    public int edit(String name, String phone, String address) throws SQLException {
        IDao dao = new DaoImpl();
        return dao.update(name, phone, address);
    }
}
