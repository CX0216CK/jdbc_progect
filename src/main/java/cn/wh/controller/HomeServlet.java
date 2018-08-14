package cn.wh.controller;

import cn.wh.bean.Users;
import cn.wh.service.ServicrFactory;
import cn.wh.service.user.IUsersSercice;
import cn.wh.util.PageUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Iterator;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends BaseServlet {
    @Override
    public void init() {
        userService = (IUsersSercice) ServicrFactory.getServiceImpl("userService");
    }

    @Override
    public Class getServletClass() {
        return HomeServlet.class;
    }

    private IUsersSercice userService;

    //当用户访问我们这个servlet的时候 先执行init
    public PageUtil findAllByPage(HttpServletRequest req, HttpServletResponse resp) {
        //获取当前页面 pageIndex
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        if (pageIndex == 0) {
            pageIndex = 1;
        }
        System.out.println(pageIndex);
        //创建PageUtil对象
        PageUtil pageUtil = new PageUtil();
        //把获取的数据封装到PageUtil
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setTotalCount(userService.findRownum());
        //调用service代码 获取数据
        List<Users> list = userService.findAllByPage(pageUtil);
        pageUtil.setList(list);

        //返回PageUtil
        return pageUtil;
    }

    public String deleteUser(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        int num = userService.deleteByCondition(id);
        if (num > 0) {
            return "main";
        }
        return "login";

    }

    /***
     * 文件上传操作
     */
    public  String  upload(HttpServletRequest req, HttpServletResponse resp){

        Users users=new Users();

        //创建DiskFileItemFactory
        DiskFileItemFactory factory=new DiskFileItemFactory();
        //创建servletFileUpload
        ServletFileUpload upload=new ServletFileUpload(factory);
        //首先判断是否为文件上传请求
        boolean flag= upload.isMultipartContent(req);
        if (flag){ //文件上传请求
            try {
                List<FileItem> items = upload.parseRequest(req);
                Iterator<FileItem> iterator = items.iterator();
                while (iterator.hasNext()){
                    //获取每一个元素   普通元素  文件元素
                    FileItem item = iterator.next();
                    if (item.isFormField()){ //普通元素
                        String fileName= item.getFieldName();
                        if (fileName.equals("userName")){
                            users.setuName(item.getString("utf-8"));
                        }
                    }else {//文件元素
                        String uploadPath = req.getSession().getServletContext().getRealPath("/upload");
                        File file=new File(uploadPath);
                        if (!file.exists()){
                            file.mkdirs();
                        }
                        //获取上传文件
                        String name = item.getName();
                        if (name!=null&&!name.equals("")){ //看用户是否选择了文件
                            File uploadFile=new File(name);
                            File saveFile=new File(uploadPath,uploadFile.getName());
                            //真正的上传
                            item.write(saveFile);
                            users.setFile(uploadPath+"\\"+uploadFile.getName());
                        }
                    }
                }
                users.setEmail("aa");
                users.setType(0);
                users.setUpwd("1111");
                int num= userService.add(users);
                if (num>0){
                    System.out.println("文件上传成功！");
                }else{
                    System.out.println("文件上传失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("压根就不是文件上传请求！ enctype!!!");
        }

        return  "add";

    }

}
