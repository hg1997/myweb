package edu.cqupt.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by hg on 2018/4/30.
 */
public class RealmDemo extends AuthorizingRealm {

    /**
     * 用于验证（登录）的方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //之前是封装为UsernamePasswordToken的对象，传递给了AuthenticationToken【向上转型】
        //这里进行【向下转型】,还原为本身的UsernamePasswordToken类型
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        //对用户名进行校验
        String username = usernamePasswordToken.getUsername();
        if(username.equals("hg")){
            throw new UnknownAccountException("账户不存在");
        }else if(username.equals("lock")){
            throw new LockedAccountException("账户被锁定");
        }

        //一般使用返回值的子类SimpleAuthenticationInfo
        /**
         * SimpleAuthenticationInfo构造器的三个参数
         * 1.principals
         * 2.credentials
         * 3.realName
         */
        Object principals = username;
        Object credentials = null;

        if(username.equals("张三")){
            credentials = "a7956ee31601a9688ded94b94bb4e001";  //假使是数据库中的张三的密码
        }else if(username.equals("李四")){
            credentials = "4ddf05b8f3072fdd06df350189629d58";  //假使是数据库中的李四的密码
        }

        String realName = getName();
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);

        System.out.println(username+"尝试登录");

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principals,credentials,credentialsSalt,realName);

        return simpleAuthenticationInfo;
    }


    /**
     * 用于登录之后，授权的方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录成功后该用户的principal
        Object principal = principalCollection.getPrimaryPrincipal();

        //创建set集合从数据库中查询该用户对应的角色或权限
        HashSet<String> set = new HashSet<>();
        if(principal.equals("张三")){
            set.add("user");  //测试时手动让“张三”为user
        }else if(principal.equals("李四")){
            set.add("user");  //测试时手动让“李四”为admin，兼顾user的权限
            set.add("admin");
        }

        //通过传递set集合封装的用户角色创建simpleAuthorizationInfo对象
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(set);
        return simpleAuthorizationInfo;
    }

    @Test
    public void test(){
        //zhangsan:a7956ee31601a9688ded94b94bb4e001
        //lisi:4ddf05b8f3072fdd06df350189629d58
        ByteSource credentialsSalt = ByteSource.Util.bytes("李四");
        System.out.println(new SimpleHash("md5","lisi",credentialsSalt,1024));
    }
}
