package com.etoak;

import org.springframework.stereotype.Component;

@Component("tea")
public class JayZhou {
	public void teach(){
		System.out.println("使劲上课");
	}
	
	public void wc()throws Exception{
		int lucky = (int)(Math.random()*2);
		if(lucky == 1)
			throw new Exception("周老师很努力 但是没有收获");
		System.out.println("周老师神清气爽");
	}
}
