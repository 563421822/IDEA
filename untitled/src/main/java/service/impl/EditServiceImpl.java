package service.impl;

import dao.ICommonDao;
import dao.impl.CommonDaoImpl;
import entity.Entity;
import service.IEditService;

import java.sql.SQLException;
import java.util.ArrayList;

public class EditServiceImpl implements IEditService {
    @Override
    public ArrayList<Entity> edit(String name) throws SQLException {
        ICommonDao dao = new CommonDaoImpl();
        return dao.QueryByName(name);
    }
}
