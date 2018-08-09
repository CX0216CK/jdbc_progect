package cn.wh.service;

import cn.wh.service.user.IUsersSercice;
import cn.wh.service.user.IUsersSerciceimpl;

public class ServicrFactory {
    //创建本类的静态对象
    private static  ServicrFactory factory;
    //私有化构造
    private ServicrFactory(){}
    static {
        if (factory==null){
            synchronized (ServicrFactory.class){
                if (factory==null){
                    factory=new ServicrFactory();
                }
            }
        }
    }
    public static IUsersSercice getServiceImpl(String serviceName) {
        IUsersSercice service=null;
        switch (serviceName){
            case "userService":
                service=new IUsersSerciceimpl();
            default:
                break;
        }
        return  service;
    }
}
