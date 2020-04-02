package com.tj.cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String resourceLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext(resourceLocation);
		
		MyCalculator myCalculator = ctx.getBean("myCal",MyCalculator.class);
		
		
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		
		ctx.close();
	}
}
