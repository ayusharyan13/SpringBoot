package com.example.jpabeans.jpabeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// once this is registered as Configuration annotation ,ready to be picked by IOC Container
@Configuration
public class MyConfig {


    // after applying bean to Method,  Register this Bean to Configuration annotation

    /*     -----------------------    Singleton Bean IOC -------------------------------

    @Bean
    public HelloWorld getHelloWorldObject() {
        return new HelloWorld();
    }


     */


    /*  -------------------------    Prototype Bean IOC  ---------------------------------

    @Bean
    @Scope("prototype")
    public HelloWorld getHelloWorldObject() {
        return new HelloWorld();
    }


     */

    @Bean
    public HelloWorld getHelloWorldObject() {
        return new HelloWorld();
    }

}


/*
         can only apply Bean on some method or some annotation
         target refers to the type of thing where we can apply Bean
         RestController cant be applied to any method/ function, only apply to class/interface/enum
 */

/*
       default: we don't need to define AnnotationConfigApplicationContext and register with : ctx.register(MyConfig.class)
       --> no need to register bean manually: automatically gets register with web application context when we run it.


       * if we use AnnotationConfigApplicationContext and register with : ctx.register(MyConfig.class)
       then the objects of annotationConfigApplication and @RestController bean will have 2 context
       and hence 2 objects will be created (regardless of singleton scope of bean)

 */