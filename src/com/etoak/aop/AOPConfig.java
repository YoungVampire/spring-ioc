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

@Component //IOC容器扫描注解的时候 请把这个类型当做一个组件
@Aspect //这是一个AOP面向切面的配置类
public class AOPConfig {
	//<aop:pointcut id="etoak()" expression="....." />
	@Pointcut("execution(* *..*.teach(..))")
	public void etoak(){}
	
	@Pointcut("execution(* *..*.wc(..))")
	public void abc(){}
	
	@Before("etoak()")
	public void first(JoinPoint jp){
		String name = jp.getSignature().getName();
		System.out.println(name + "前置非核心：收手机~");
	}
	//@After("etoak()")
	@AfterReturning("etoak()")
	public void last(){
		System.out.println("后置非核心：看自习");
	}
	@Around("etoak()")
	public Object work(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("==Around当中的前置==");
		Object ok = pjp.proceed();//tea.teach();
		System.out.println("==Around当中的后置==");
		return ok;
	}
	
	@AfterThrowing(value="abc()",throwing="aaa")
	public void et2003(JoinPoint p,Exception aaa){
		System.out.println("啊"+p.getSignature().getName()+" 出事了:"+aaa.getMessage()+" 快去帮助他！");
	}
	
	
}




