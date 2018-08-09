package cn.wh.util;

import java.sql.*;

public class BasoDao {
    /**
     * JDBC需要的API
     */
    protected Connection connection;  //连接
    protected PreparedStatement ps;  //执行sql语句
    protected ResultSet rs;  //返回的结果集

    /**
     * 01.连接数据库
     */
    public boolean  getConncetion(){
        try {
            //加载驱动
            Class.forName(ConfigManager.getValue("jdbc.driver"));
            connection= DriverManager.getConnection(ConfigManager.getValue("jdbc.url"),
                    ConfigManager.getValue("jdbc.username"),
                    ConfigManager.getValue("jdbc.password"));
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }
        return true;
    }

    /**
     * 02.增删改
     */
    public  int executeUpdate(String sql,Object...params){
        int num=0;
        if (getConncetion()){
            try {
                ps= connection.prepareStatement(sql); //获取执行sql语句的对象
                if (params!=null){ //有参数  有几个？
                    for (int i = 0; i <params.length ; i++) {
                        ps.setObject(i+1,params[i]);
                    }
                }
                num= ps.executeUpdate();//调用底层代码
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closeConnection(); //释放资源
            }
        }
        return  num;
    }

    /**
     * 03.查
     */
    public ResultSet executeQuery(String sql, Object...params){
        if (getConncetion()){
            try {
                ps= connection.prepareStatement(sql); //获取执行sql语句的对象
                if (params!=null){ //有参数  有几个？
                    for (int i = 0; i <params.length ; i++) {
                        ps.setObject(i+1,params[i]);
                    }
                }
                rs= ps.executeQuery();//调用底层代码
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  rs;
    }


    /**
     * 04.释放资源
     */
    public void closeConnection(){
        try {
            if (rs!=null){
                rs.close();  //释放结果集
            }
            if (ps!=null){
                ps.close();
            }
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
