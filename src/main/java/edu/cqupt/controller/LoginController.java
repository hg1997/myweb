package edu.cqupt.controller;

import edu.cqupt.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aa on 2017/8/2.
 */
@Controller
public class LoginController {
    @Autowired
   private UserServiceImpl userService;
    //注册校验
    @RequestMapping("/regist")
    public void regist(HttpServletRequest request,
                      HttpServletResponse response,
                      String username) throws IOException {

        request.getParameter("username");
        System.out.println("ajax发送username-->"+username);

        //
        boolean exist = userService.existUser(username);
        System.out.println("查询结果:"+exist);
        if(exist)
            response.getWriter().print("您注册的用户已存在！");
        else
            response.getWriter().print("");
    }

    @RequestMapping("/show")
    public void show(HttpServletResponse response) throws IOException {
       response.getWriter().print("test");
    }
}
