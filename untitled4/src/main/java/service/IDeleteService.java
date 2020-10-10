package service;

import java.sql.SQLException;

public interface IDeleteService {
    int delete(String name) throws SQLException;
}
