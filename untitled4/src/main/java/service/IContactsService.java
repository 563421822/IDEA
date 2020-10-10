package service;

import entity.ContactsEntity;
import utils.Page;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IContactsService {
    ArrayList<ContactsEntity> show(Page page) throws SQLException;
}
