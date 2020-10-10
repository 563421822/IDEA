package service;

import entity.ContactsEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDetailService {
    ArrayList<ContactsEntity> detail(String name) throws SQLException;
}
