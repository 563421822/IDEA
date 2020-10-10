package service;

import entity.Entity;
import utils.Page;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IManageService {
    ArrayList<Entity> manage(Page page) throws SQLException;
}
