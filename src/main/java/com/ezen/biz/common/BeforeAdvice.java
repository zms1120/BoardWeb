package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
//	@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
//	public void allPointcut() {}	// ����Ʈ�� ID
	
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		Signature sig = jp.getSignature();
		String method = sig.getName();	// ����Ͻ� �޼ҵ� �̸��� ���´�.
		Object[] args = jp.getArgs();  // �޼ҵ� ȣ�� �� ���������� �����´�.
		
		System.out.println("\n[���� ó��] ����Ͻ� ���� ���� �� �۾�...");
		if (args.length == 0) {
			System.out.printf("�޼ҵ��: %s(), args:����\n", method);
		} else {
			System.out.printf("�޼ҵ��: %s(), args:%s\n", method, args[0]);
		}
	}
}
