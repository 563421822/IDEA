package service.impl;

import dao.ICommonDao;
import dao.impl.CommonDaoImpl;
import entity.Entity;
import service.IManageService;
import utils.Page;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageServiceImpl implements IManageService {

    /**
     * 分页查询所有用户
     *
     * @param page
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<Entity> manage(Page page) throws SQLException {
        ICommonDao dao = new CommonDaoImpl();
//        设置总记录条数
        page.setTotalCount(dao.queryCount());

//        设置每页显示的条数
        page.setPageSize(10);

//        设置总页数
        page.setTotalPage((int) Math.ceil(page.getTotalCount() / page.getPageSize()));

//        设定起始页数
        page.setStart((page.getCurrentPage() - 1) * (page.getPageSize()));

        return dao.queryAll(page);
    }
}
