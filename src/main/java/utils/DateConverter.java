package utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hg on 2018/4/20.
 */
public class DateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd ");
        try {
            System.out.println("获取的原始string:"+s);
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("parse字符串出错。。。。。");
        }
        return null;
    }
}
