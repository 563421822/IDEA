package service;

import entity.Entity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IEditService {
    ArrayList<Entity> edit(String name) throws SQLException;
}
