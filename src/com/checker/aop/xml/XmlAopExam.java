package com.checker.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


public class XmlAopExam {


    public Object arroundAdd(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        Object proceed = null;
        try {

            System.out.println("前置");

            // 反射调用目标方法，即method.invoke(obj,args);
            proceed = proceedingJoinPoint.proceed(args);

            System.out.println("后置");

        } catch (Throwable throwable) {
            System.out.println("异常");
        } finally {
            System.out.println("最终");
        }

        return proceed;
    }


    public void beforeAdd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "的before方法，参数：" + Arrays.toString(joinPoint.getArgs()));
    }


    public void afterAdd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "的after方法，参数：" + Arrays.toString(joinPoint.getArgs()));
    }


    public void afterReturingAdd(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "的afterReturing方法，参数：" + Arrays.toString(joinPoint.getArgs()) + "返回值：" + result);
    }

    public void afterThrowingAdd(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName() + "的afterThrowing方法，参数：" + Arrays.toString(joinPoint.getArgs()) + "异常：" + exception);

    }

}
