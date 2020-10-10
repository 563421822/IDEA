package com.wyl.zy.service;

import com.wyl.zy.entity.GameEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IGameService {
    boolean topUp(String account, double sum) throws SQLException;

    ArrayList<GameEntity> showAll() throws SQLException;

    boolean buy(int chosenId, int num) throws Exception;

}
