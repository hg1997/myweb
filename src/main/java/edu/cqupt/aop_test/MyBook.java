package edu.cqupt.aop_test;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by hg on 2018/3/9.
 */


//切面类，用于给其他类的方法（切点 pointcut）增强

@Aspect
@Component
public class MyBook {

    //前置通知
    @Before(value = "execution(* edu.cqupt.aop_test.Book.*(..))")
    public void before(){
        System.out.println("before reading...");
    }
}
