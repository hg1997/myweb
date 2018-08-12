package edu.cqupt.controller;

import edu.cqupt.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by aa on 2017/8/2.
 */
@Controller
public class UserController {

    //用户登陆
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        // 获取当前user
        Subject user = SecurityUtils.getSubject();

        //未登录，则进行登录
        if (!user.isAuthenticated()) {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            //remember me
            usernamePasswordToken.setRememberMe(true);


            try {
                user.login(usernamePasswordToken);

            } catch (UnknownAccountException e) {
                System.out.println(e.getMessage());
            } catch (LockedAccountException e) {
                System.out.println(e.getMessage());
            } catch (AuthenticationException ae) {
                System.out.println("都不是上述异常，父类异常进行匹配，登录失败！");
            }
        }
        //通过验证
        return "redirect:/jsp/success.jsp";
    }

    //上传用户头像
    @RequestMapping(value = "/uploadImage")
    public void uploadImage(HttpServletRequest request, MultipartFile userImage) throws IOException {
        //拼凑头像的文件名，如2015211.jpg
        String imageName = userImage.getOriginalFilename();
        User user = (User) request.getSession().getAttribute("user");
        String username = user.getUsername();
        imageName = username + imageName.substring(imageName.lastIndexOf("."));

        //头像存储路径
        String imagePath = request.getSession().getServletContext().getRealPath("/userImage") + "\\" + imageName;

        //上传
        File file = new File(imagePath);
        userImage.transferTo(file);

        System.out.println("上传完成。。。。。。。。。。。。。。！");

    }


}
