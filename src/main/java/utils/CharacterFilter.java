package utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aa on 2017/11/3.
 */
public class CharacterFilter implements Filter {
    String character;


    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        //先强转一波
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        //请求（针对post）  响应 编码处理
        response.setContentType("text/html;charset="+character);
        request.setCharacterEncoding(character);

        //获取请求方法
        String method = request.getMethod();

        //根据不同的请求方法采取动作
        if(method.equalsIgnoreCase("post")){
            chain.doFilter(req, response);
        }else{
            chain.doFilter(new CharacterRequest(request,character), response);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        //获取指定使用的编码
        //没有指定默认使用utf-8
         character = config.getInitParameter("character");
         if(!StringUtils.notEmpty(character)){
             character = "utf-8";
         }

        System.out.println("character:"+character);
    }

}
