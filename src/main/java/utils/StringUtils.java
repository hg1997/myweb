package utils;

import java.io.InputStream;
import java.util.UUID;

/**
 * Created by aa on 2017/11/2.
 */
public class StringUtils {

    /**
     * 字符串的非空校验
     * @param str
     * @return
     */
    public static boolean notEmpty(String str){
        return str!=null && !str.trim().equals("");
    }

    /**
     * 获取项目的classpath
     * @return
     */
    public static String getClassPath(){
         return StringUtils.class.getClassLoader().getResource("").toString();
    }

    /**
     * 获取classPath下的资源
     * @param path
     * @return
     */
    public static InputStream getResourceAsStream(String path){
        return StringUtils.class.getClassLoader().getResourceAsStream(path);
    }

    /**
     * 获取uuid:32位16进制数；替换中间的“-”
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");

    }
}
