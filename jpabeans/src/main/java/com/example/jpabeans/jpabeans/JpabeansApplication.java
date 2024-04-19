package com.example.jpabeans.jpabeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class JpabeansApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpabeansApplication.class, args);


		// registering MyConfig class to be picked by IOC container:
		// Now you can create multiple beans in MyConfig class with different return type
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(MyConfig.class);

		// now: refresh the ctx: unless it will give illegalStateException:
		ctx.refresh();

		// need to specify which bean you want to get:
		HelloWorld obj1 = ctx.getBean(HelloWorld.class);
//		HelloWorld obj2 = ctx.getBean(HelloWorld.class);

		obj1.setData("This is data");
		obj1.setMessage("this is message");
		// now after getting bean obj--> can simply use it or print it
		System.out.println(obj1);

		// even if we have not set anything for obj2: obj2 have same value as obj1:
		// due to bean reference (singleton object has been created and its reference is thrown each time:

		//     ---- to make new object  ==> do prototype bean --> @Bean Scope to :prototype
//		System.out.println(obj2);

	}



}
