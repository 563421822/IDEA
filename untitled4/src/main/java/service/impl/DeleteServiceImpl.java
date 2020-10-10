package service.impl;

import dao.IDao;
import dao.impl.DaoImpl;
import service.IDeleteService;

import java.sql.SQLException;

public class DeleteServiceImpl implements IDeleteService {
    @Override
    public int delete(String name) throws SQLException {
        IDao dao = new DaoImpl();
        return dao.delete(name);

    }
}
