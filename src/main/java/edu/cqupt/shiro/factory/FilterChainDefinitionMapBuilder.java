package edu.cqupt.shiro.factory;

import java.util.LinkedHashMap;

/**
 * Created by hg on 2018/5/2.
 */
public class FilterChainDefinitionMapBuilder {
    public LinkedHashMap<String,String> buildFilterChainDefinitionMap(){

        LinkedHashMap<String,String> map = new LinkedHashMap<>();

        map.put("/login","anon");
        map.put("/jsp/login.jsp","anon");
        // 通过remember me 可进入的网站
        map.put("/jsp/me.jsp","user");

        map.put("/jsp/user.jsp","roles[user]");
        map.put("/jsp/admin.jsp","roles[admin]");
        map.put("/**","authc");

        return map;
    }
}
