package cn.wh.controller;

import cn.wh.util.ResultUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class UserServlet extends BaseServlet {
    @Override
    public Class getServletClass() {


        System.out.println("=====02:UserServlet===》getServletClass");


        return UserServlet.class;


    }








    public ResultUtil login(HttpServletRequest req, HttpServletResponse resp){


        System.out.println("====>UserServlet===>login");


        //获取用户登录的用户名和密码


        String userName=req.getParameter("username");


        String password=req.getParameter("password");


        ResultUtil util=new ResultUtil();


        //得从数据库中获取一个用户名  如果没有用户名不需要再执行后续代码


        if (userName.equals("admin")){


            util.resultSuccess(userName);


        }else{


            util.resultFail("用户名错误");


        }


        //调用MD5验证密码


        return util;


    }
}
