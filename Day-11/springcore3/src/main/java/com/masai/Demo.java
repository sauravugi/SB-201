package com.masai;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {


		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		A a1 = ctx.getBean("a",A.class);
		
		a1.funA();
		
		((AnnotationConfigApplicationContext)ctx).close();
	}

}
