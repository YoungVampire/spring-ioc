package com.etoak.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etoak.JayZhou;

public class TestSpringAnnotation {

	public static void main(String[] args) throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		JayZhou jay = ac.getBean("tea",JayZhou.class);
		//jay.teach();
		jay.wc();
	}

}
