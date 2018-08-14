package cn.wh.dao.user;

import cn.wh.bean.Users;
import cn.wh.util.BasoDao;
import cn.wh.util.PageUtil;
import cn.wh.util.ResultSetUtil;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IUserDaoImpl extends BasoDao implements IUserDao {

    @Override
    public int add(Users users) {
        String sql = "INSERT `news_userinfo` (`uname`,`upwd`,`email`,`type`,`file`) VALUES(?,?,?,?,?)";
        Object[] obj = {users.getuName(), users.getUpwd(), users.getEmail(), users.getType(),users.getFile()};

        return executeUpdate(sql, obj);
    }

    @Override
    public int deleteByCondition(Serializable id) {
        String sql="delete FROM news_userinfo where uid= ?";
        int count = executeUpdate(sql, id);

        return count;
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
        String sql="SELECT count(1) as count FROM `news_userinfo`";
        rs = executeQuery(sql);
        int count=0;
        try {
            if (rs.next()){
                count=rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Users> findAllByPage(PageUtil util, Object... params) {
        String sql="SELECT uid,uname,upwd,email,type ,`file` from news_userinfo LIMIT ?,?";
        Object [] obj={(util.getPageIndex()-1)*util.getPageSize(),  util.getPageSize()};
        rs=executeQuery(sql,obj);
        List<Users> users = ResultSetUtil.eachList(rs, Users.class);
        return users;
    }

    @Override
    public String validateName(String userName) {
        String sql = "SELECT upwd  FROM `news_userinfo` WHERE uname=?";
        rs = executeQuery(sql, userName);
        String password = null;
        try { //获取密码
            if (rs.next()) {
                password = rs.getString("upwd");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;

    }

    @Override
    public Users login(String userName, String passwordInDB) {
        String sql="SELECT `uid`,`uname`,upwd,`email`,`type`,`file` FROM `news_userinfo` WHERE uname=? and upwd=? ";
        Object [] params={userName,passwordInDB};
        rs=executeQuery(sql,params);
        Users users= ResultSetUtil.eachOne(rs,Users.class);
        return users;
    }
}
