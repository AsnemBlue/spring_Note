package com.tj.ex2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String loc= "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(loc);
		AdminInfo info = ctx.getBean("adminInfo",AdminInfo.class);
		System.out.println(info.getAdminId());
		System.out.println(info.getAdminPw());
		System.out.println(info.getSub_adminId());
		System.out.println(info.getSub_adminPw());
		ctx.close();
	}
}
