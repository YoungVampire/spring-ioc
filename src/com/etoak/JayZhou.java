package com.etoak;

import org.springframework.stereotype.Component;

@Component("tea")
public class JayZhou {
	public void teach(){
		System.out.println("ʹ���Ͽ�");
	}
	
	public void wc()throws Exception{
		int lucky = (int)(Math.random()*2);
		if(lucky == 1)
			throw new Exception("����ʦ��Ŭ�� ����û���ջ�");
		System.out.println("����ʦ������ˬ");
	}
}
