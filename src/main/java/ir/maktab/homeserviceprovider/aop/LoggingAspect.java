package ir.maktab.homeserviceprovider.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("within(ir.maktab.homeserviceprovider..*)")
    public void logBefore(JoinPoint joinPoint) {
        log.info("@Before: " + joinPoint.getSignature().toShortString());
    }

    @After("within(ir.maktab.homeserviceprovider..*)")
    public void logAfter(JoinPoint joinPoint) {
        log.debug("@After: " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(value = "within(ir.maktab.homeserviceprovider..*)", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringType(),
                joinPoint.getSignature().getName(), e.getMessage() != null ? e.getMessage() : "NULL");
    }
}
