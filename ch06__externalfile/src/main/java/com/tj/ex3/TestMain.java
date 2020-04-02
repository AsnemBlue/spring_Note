package com.tj.ex3;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String config = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("dev? run?");
		config = scanner.next();
		if(!config.contentEquals("dev")) {
			config = "run";
		}
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("applicationCTX_dev.xml","applicationCTX_run.xml");
		Serverinfo serverInfo = ctx.getBean("serverInfo",Serverinfo.class);
		System.out.println(serverInfo.getIpNum());
		System.out.println(serverInfo.getPortNum());
		ctx.close();
	}
}
