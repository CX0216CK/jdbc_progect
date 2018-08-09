package cn.wh.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 这是一个单例类！
 * 因为用户访问我们项目目的就是访问对应的数据库
 * 数据库连接的四要素 我们让所有用户共享一个足矣！
 */
public class ConfigManager {
    // 01.创建需要单例类的静态变量
    private static  ConfigManager configManager;
    //创建Properties对象  专门解析properties文件的
    private static Properties properties;
    //02.静态代码块 不会实例化对象 就能使用
    static{
        String path="jdbc.properties";
        properties=new Properties(); //实例化对象
        InputStream stream = ConfigManager.class.getClassLoader().getResourceAsStream(path);
        //加载我们自己的properties文件
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //03.创建对外访问的接口
    public static  synchronized ConfigManager getInstance(){
        return configManager;
    }
    /**
     * properties对象已经有值了！properties已经进入了内存！
     * 我们就可以通过key获取value
     */
    public static  String  getValue(String key){
        return properties.getProperty(key);
    }
}