package edu.cqupt.controller;

import edu.cqupt.domain.User;
import edu.cqupt.serviceImpl.UserServiceImpl;
import edu.cqupt.utils.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by aa on 2017/8/3.
 */
@Controller
public class VerifyCodeController {
    @Autowired
    private UserServiceImpl userService;

    private String text;

    @RequestMapping("/verifyCode")
    public  void verifyCode(HttpServletRequest request, HttpServletResponse response){

        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        text = verifyCode.getText();
        try {
            OutputStream outputStream = response.getOutputStream();
            verifyCode.output(image,outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/login")
    public void login(HttpServletRequest request,
                      HttpServletResponse respone,
                      User user)throws Exception{

        boolean  flag = userService.checkUser(user);
        if(flag){
            request.setAttribute("user",user.getUsername());
            request.getRequestDispatcher("/index.jsp").forward(request,respone);
        }else{
            request.setAttribute("msg","账号或密码错误");
            //respone.sendRedirect("/myweb/jsp/login.jsp");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request,respone);
        }
    }

}
