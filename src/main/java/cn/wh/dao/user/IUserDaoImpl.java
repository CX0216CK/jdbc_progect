package cn.wh.dao.user;

import cn.wh.bean.Users;
import cn.wh.util.BasoDao;
import cn.wh.util.PageUtil;

import java.io.Serializable;
import java.util.List;

public class IUserDaoImpl extends BasoDao implements IUserDao {

    @Override
    public int add(Users users) {
        String sql = "INSERT `news_userinfo` (`uname`,`upwd`,`email`,`type`) VALUES(?,?,?,?)";
        Object[] obj = {users.getuName(), users.getUpwd(), users.getEmail(), users.getType()};

        return executeUpdate(sql, obj);
    }

    @Override
    public int deleteByCondition(Serializable id) {
        return 0;
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
        return 0;
    }

    @Override
    public List<Users> findAllByPage(PageUtil util, Object... params) {
        return null;
    }
}
