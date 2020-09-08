package com.etoak.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //IOC����ɨ��ע���ʱ�� ���������͵���һ�����
@Aspect //����һ��AOP���������������
public class AOPConfig {
	//<aop:pointcut id="etoak()" expression="....." />
	@Pointcut("execution(* *..*.teach(..))")
	public void etoak(){}
	
	@Pointcut("execution(* *..*.wc(..))")
	public void abc(){}
	
	@Before("etoak()")
	public void first(JoinPoint jp){
		String name = jp.getSignature().getName();
		System.out.println(name + "ǰ�÷Ǻ��ģ����ֻ�~");
	}
	//@After("etoak()")
	@AfterReturning("etoak()")
	public void last(){
		System.out.println("���÷Ǻ��ģ�����ϰ");
	}
	@Around("etoak()")
	public Object work(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("==Around���е�ǰ��==");
		Object ok = pjp.proceed();//tea.teach();
		System.out.println("==Around���еĺ���==");
		return ok;
	}
	
	@AfterThrowing(value="abc()",throwing="aaa")
	public void et2003(JoinPoint p,Exception aaa){
		System.out.println("��"+p.getSignature().getName()+" ������:"+aaa.getMessage()+" ��ȥ��������");
	}
	
	
}




