package cn.wh.service.user;

import cn.wh.bean.Users;
import cn.wh.dao.user.IUserDao;
import cn.wh.dao.user.IUserDaoImpl;
import cn.wh.util.PageUtil;

import java.io.Serializable;
import java.util.List;

public class IUsersSerciceimpl implements IUsersSercice {
    //耦合 加上 静态代理
    private IUserDao userDao=new IUserDaoImpl();
    @Override
    public int add(Users users) {
        return userDao.add(users);
    }

    @Override
    public int deleteByCondition(Serializable id) {
        return userDao.deleteByCondition(id);
    }

    @Override
    public int update(Users users) {
        return 0;
    }

    @Override
    public Users findByCondition(Serializable id) {
        return null;
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public int findRownum() {
        return userDao.findRownum();
    }

    @Override
    public List<Users> findAllByPage(PageUtil util, Object... params) {
        return userDao.findAllByPage(util);
    }

    @Override
    public String validateName(String userName) {
        return userDao.validateName(userName);
    }

    @Override
    public Users login(String userName, String passwordInDB) {
        return userDao.login(userName,passwordInDB);
    }
}
