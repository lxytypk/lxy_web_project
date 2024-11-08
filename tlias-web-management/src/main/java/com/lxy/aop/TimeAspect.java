package com.lxy.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect //AOP类
public class TimeAspect {
//    @Pointcut("execution(* com.lxy.service.DeptService.list()) || " +
//            "execution(* com.lxy.service.DeptService.delete(java.lang.Integer))")
    @Pointcut("@annotation(com.lxy.aop.MyLog)")
    private void pt(){}

    @Before("pt()")
    public void before(JoinPoint joinPoint){
        log.info("before...");
    }

    @Around("pt()") //切入点表达式
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1.获取 目标对象的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 2.获取 目标对象的方法名
        String methodName = joinPoint.getSignature().getName();
        // 3.获取 目标对象运行时传入的参数
        Object[] args = joinPoint.getArgs();
        // 4.获取 目标方法执行
        Object result = joinPoint.proceed();
        // 5.获取 目标方法运行的返回值
        log.info("目标方法运行时的返回值：{}",result);
        return result;
    }
}