package ir.maktab.homeservice.aop.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("within(ir.maktab.homeservice..*)")
    public void logBefore(JoinPoint joinPoint) {
        log.info("@Before: " + joinPoint.getSignature().toShortString() + " | Args: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("within(ir.maktab.homeservice..*)")
    public void logAfter(JoinPoint joinPoint) {
        log.debug("@After: " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(value = "within(ir.maktab.homeservice..*)", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringType(),
                joinPoint.getSignature().getName(), e.getMessage() != null ? e.getMessage() : "NULL");
    }

}
