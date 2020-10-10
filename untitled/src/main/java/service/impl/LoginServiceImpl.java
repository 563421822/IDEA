package service.impl;

import dao.ICommonDao;
import dao.impl.CommonDaoImpl;
import service.ILoginService;

public class LoginServiceImpl implements ILoginService {
    @Override
    public int login(String username, String password, String role) throws Exception {
        ICommonDao dao = new CommonDaoImpl();
        return dao.queryByInfo(username, password, role);
    }
}
