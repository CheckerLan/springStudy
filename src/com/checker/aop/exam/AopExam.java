package com.checker.aop.exam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 标注切面类
@Aspect
// 加入ioc容器
@Component
public class AopExam {

    @Pointcut("execution(public void com.checker.dao.impl.UserDAOImpl.add())")
    public void myPointcut() {
    }

    //@Before("myPointcut()")
    public void beforeAddByPointcut() {
        System.out.println("【利用Pointcut抽出表达式的通知方法】");
    }

    @Around("myPointcut()")
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

    @Before("execution(public void com.checker.dao.impl.UserDAOImpl.add())")
    public void beforeAdd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "的before方法，参数：" + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(public void com.checker.dao.impl.UserDAOImpl.add())")
    public void afterAdd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "的after方法，参数：" + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "execution(public void com.checker.dao.impl.UserDAOImpl.add())", returning = "result")
    public void afterReturingAdd(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "的afterReturing方法，参数：" + Arrays.toString(joinPoint.getArgs()) + "返回值：" + result);
    }

    @AfterThrowing(value = "execution(public void com.checker.dao.impl.UserDAOImpl.add())", throwing = "exception")
    public void afterThrowingAdd(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName() + "的afterThrowing方法，参数：" + Arrays.toString(joinPoint.getArgs()) + "异常：" + exception);

    }

}
