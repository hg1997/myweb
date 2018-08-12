package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * Created by aa on 2017/11/3.
 */
public class CharacterRequest extends HttpServletRequestWrapper{

    //字符编码+request  -- > 对应构造
    private String charater;
    private HttpServletRequest request;

    public CharacterRequest(HttpServletRequest request,String charater) {
        super(request);
        this.charater = charater;
        this.request = request;

    }

    //   ==================================

    /**
     * 装饰者模式：针对get请求增强getParameter方法---> 编一次，解一次
     * @param name
     * @return
     */
    @Override
    public String getParameter(String name) {
        String value = request.getParameter(name);
        try {
            if(StringUtils.notEmpty(value)){
                return new String(value.getBytes("iso8859-1"),charater);
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
