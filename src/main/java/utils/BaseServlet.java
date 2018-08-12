package utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

import static utils.StringUtils.notEmpty;


/**
 * Created by aa on 2017/11/2.
 */
public class BaseServlet extends HttpServlet {

    /**
     * > 重写HttpServlet内部自定义的service方法
     * > 利用反射的方式根据请求参数调用方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //解决请求和响应字符的问题
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //System.out.println("baseServlet执行。。。。");

        //根据请求参数method的值利用反射调用方法
        String method  = request.getParameter("method");
        if(notEmpty(method)){
          //反射
            Class clazz = this.getClass();
            try {
                //根据参数名执行对应方法
                Method m = clazz.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
                String result = (String) m.invoke(this,request,response);

                //根据方法执行的结果进行转发或重定向
                if(notEmpty(result)){
                    int spliter = result.indexOf(":");
                    if(spliter!= -1){ //包含 “ ：” 分号
                        //按分号切分为前缀为后缀
                        // 例如： redirect:/index.jsp
                        String prefix = result.substring(0,spliter);
                        String path = result.substring(spliter+1);

                        if(prefix.equals("forward")){ //转发
                            request.getRequestDispatcher(result.substring(spliter+1)).forward(request,response);
                        }else if(prefix.equals("redirect")){ //重定向
                            response.sendRedirect(request.getContextPath()+result.substring(spliter+1));
                        }
                    }else{ //不包含分号，默认为转发
                        request.getRequestDispatcher(result).forward(request,response);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw  new RuntimeException(e);
            }
        }
    }
}
