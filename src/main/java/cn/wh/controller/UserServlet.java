package cn.wh.controller;

import cn.wh.bean.Users;
import cn.wh.service.ServicrFactory;
import cn.wh.service.user.IUsersSercice;
import cn.wh.util.Md5Encrypt;
import cn.wh.util.ResultUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/login")
public class UserServlet extends BaseServlet {

    //不实例化service层对象  让工厂去实例化
    private IUsersSercice userService;
    @Override
    public Class getServletClass() {
        return UserServlet.class;
    }
    @Override
    public void init() throws ServletException {
        userService=(IUsersSercice) ServicrFactory.getServiceImpl("userService");
    }
    /**
     * 用户注册的方法
     */
    public  String  register(HttpServletRequest req, HttpServletResponse resp){
        //获取用户输入的参数
        String userName=req.getParameter("username");
        String password=req.getParameter("password");
        Users users=new Users();
        users.setuName(userName);
        try {
            users.setUpwd(Md5Encrypt.getEncryptedPwd(password));
            System.out.println(users.getUpwd());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        users.setType(0);  //设置用户类型
        int num= userService.add(users);
        if (num>0){
            return  "main";
        }else{
            return "register";
        }
    }

    public ResultUtil login(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("====>UserServlet===>login");
        //获取用户登录的用户名和密码
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        ResultUtil util = new ResultUtil();
        //得从数据库中获取一个用户名  如果没有用户名不需要再执行后续代码
        if (userName.equals("admin")) {
            util.resultSuccess(userName);
        } else {

            util.resultFail("用户名错误");


        }


        //调用MD5验证密码


        return util;


    }
}
