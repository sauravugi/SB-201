package springcore4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {
		
		ApplicationContext ctx  = new AnnotationConfigApplicationContext(AppConfig.class);

		Bike b = ctx.getBean("bike",Bike.class);
		
		b.funBike();
		
		Car c = ctx.getBean("car",Car.class);
		
		c.funCar();
		
		Travel t = ctx.getBean("travel",Travel.class);
		
		t.funTravel();
		
		((AnnotationConfigApplicationContext)ctx).close(); // here destroy method is not called
														   // because scope is prototype
	}

}
