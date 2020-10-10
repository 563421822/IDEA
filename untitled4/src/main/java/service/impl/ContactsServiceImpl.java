package service.impl;

import dao.IDao;
import dao.impl.DaoImpl;
import entity.ContactsEntity;
import service.IContactsService;
import utils.Page;

import java.sql.SQLException;
import java.util.ArrayList;

public class ContactsServiceImpl implements IContactsService {
    /**
     * 分页对象属性初始化
     *
     * @param page
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<ContactsEntity> show(Page page) throws SQLException {
        IDao dao = new DaoImpl();
        //        设置每页显示的条数
        page.setPageSize(5);
        //        设置所有的条数
        page.setTotalCount(dao.queryCount());
//        设置当起始记录条数,=(当前页页码-1)×每页展示的条数
        page.setStartCount((page.getCurrentPage() - 1) * page.getPageSize());
        System.out.println((double) page.getTotalCount() / page.getPageSize());
//        设置总页数
        page.setTotalPage((int) Math.ceil((double) page.getTotalCount() / page.getPageSize()));
        return dao.queryAll(page);
    }
}