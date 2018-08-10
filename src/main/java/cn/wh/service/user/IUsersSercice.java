package cn.wh.service.user;

import cn.wh.bean.Users;
import cn.wh.dao.IBasoDao;
import cn.wh.service.IBasoService;

public interface IUsersSercice extends IBasoService<Users> {
    String validateName(String userName);

    Users login(String userName, String passwordInDB);
}
