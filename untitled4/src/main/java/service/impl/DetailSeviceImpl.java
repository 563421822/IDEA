package service.impl;

import dao.IDao;
import dao.impl.DaoImpl;
import entity.ContactsEntity;
import service.IDetailService;

import java.sql.SQLException;
import java.util.ArrayList;

public class DetailSeviceImpl implements IDetailService {
    @Override
    public ArrayList<ContactsEntity> detail(String name) throws SQLException {
        IDao dao = new DaoImpl();
        return dao.queryDetail(name);
    }
}
