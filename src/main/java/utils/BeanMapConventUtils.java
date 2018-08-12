package utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aa on 2017/11/1.
 */
public class BeanMapConventUtils {

    /**
     * 将map里的键值对转换为javaBean
     *
     * @param map
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T toBean(Map map, T bean) {
        //内省折腾bean
        Class clazz = bean.getClass();
        try {
            //1.获取beanInfo
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);

            //2.获取属性描述符
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

            //3.遍历属性
            String propertyName = null;
            for (PropertyDescriptor pd : pds) {
                propertyName = pd.getName();
                if (map.containsKey(propertyName)) {//将集合里与bean匹配的属性扔到bean中
                    pd.getWriteMethod().invoke(bean, map.get(propertyName));
                }
            }
            //4.循环完毕后返回bean
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("map转换为bean出错！");
        }
    }

    /**
     * 将javaBean里的属性转换为Map里的键值对
     *
     * @param bean
     * @return
     */
    public static Map toMap(Object bean) {
        //1.内部创建Map用于返回
        HashMap hashMap = new HashMap();

        Class clazz = bean.getClass();
        try {
            //2.获取beanInfo
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);

            //3.获取属性描述符
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

            //4.遍历属性放入map中
            String propertyName = null;
            for (PropertyDescriptor pd : pds) { //排除class属性
                if (!(propertyName = pd.getName()).equals("class")) {
                    Object value = pd.getReadMethod().invoke(bean);
                    hashMap.put(propertyName, value); //放入map集合中
                }
            }

            //5.遍历完成，返回map
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("javaBean转换为Map出错！");
        }
    }
}
