package cn.wh.dao.user;

import cn.wh.bean.Users;
import cn.wh.dao.IBasoDao;

public interface IUserDao extends IBasoDao<Users> {

    String validateName(String userName);

    Users login(String userName, String passwordInDB);
}
