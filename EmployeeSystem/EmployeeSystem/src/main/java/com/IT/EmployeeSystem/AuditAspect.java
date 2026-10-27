package com.IT.EmployeeSystem;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {
    @Before("execution(* com.IT.EmployeeSystem.EmployeeService.*(..))")
    public void beforeServiceCall(JoinPoint jp) {
        System.out.println("[AUDIT] Calling " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.IT.EmployeeSystem.EmployeeService.*(..))")
    public void afterServiceCall(JoinPoint jp) {
        System.out.println("[AUDIT] Completed " + jp.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.IT.EmployeeSystem.EmployeeService.*(..))", throwing = "ex")
    public void serviceFailed(JoinPoint jp, Throwable ex) {
        System.out.println("[AUDIT] Failed " + jp.getSignature().getName() + ": " + ex.getMessage());
    }
}