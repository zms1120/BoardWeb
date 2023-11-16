package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
//	@Pointcut("execution (* com.ezen.biz..*Impl.*(..))")
//	public void allPointcut() {}
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// ����Ͻ� �޼ҵ� ȣ��
		// returnObj - ����Ͻ� �޼ҵ� ���� �� ����� ��� ����
		Object returnObj = pjp.proceed();
		
		stopWatch.stop();
		System.out.printf("�޼ҵ� %s() ���࿡ �ɸ� �ð�:%d(ms)\n",
				method, stopWatch.getTotalTimeMillis());
		
		return returnObj;
	}
}
