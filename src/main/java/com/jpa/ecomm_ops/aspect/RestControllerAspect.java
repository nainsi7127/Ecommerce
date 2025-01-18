/**
 * Aspect for logging input, output, and exceptions for REST controllers.
 *
 * <p>This aspect intercepts method calls to all {@link RestController} classes within the application
 * and logs the details of requests, method executions, responses, and any exceptions that occur.</p>
 *
 * <p>Author: Suvam Mohapatra</p>
 * <p>Email: suvam.mohapatra@sita.aero</p>
 */
package com.jpa.ecomm_ops.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class RestControllerAspect {

    /**
     * Pointcut for all classes annotated with {@link org.springframework.web.bind.annotation.RestController}.
     */

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void restControllerClass() {}

    /**
     * Pointcut for all methods within classes in the com.safetycube.app_config.web.controller package.
     */

    @Pointcut("execution(* com.safetycube.app_config.web.controller..*(..))")
    public void restControllerMethods() {}

    /**
     * Advice executed before a method call. Logs method name, class name, and arguments.
     *
     * @param joinPoint the join point at which the advice is applied
     */

    @Before("restControllerMethods()")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();

        log.info("Calling method {} in class {} with arguments: {}", methodName, className, args);
    }

    /**
     * Advice executed after a method successfully returns. Logs method name, class name, and return value.
     *
     * @param joinPoint the join point at which the advice is applied
     * @param result the result returned by the method
     */

    @AfterReturning(pointcut = "restControllerMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        log.info("Method {} in class {} returned: {}", methodName, className, result);
    }

    /**
     * Advice executed if an exception is thrown during method execution. Logs method name, class name, and exception details.
     *
     * @param joinPoint the join point at which the advice is applied
     * @param exception the exception thrown by the method
     */

    @AfterThrowing(pointcut = "restControllerMethods()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        log.error("Exception in method {} in class {}: {}", methodName, className, exception.getMessage(), exception);
    }
}

