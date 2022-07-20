package org.genspark;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        //BeanFactory

        //Application Context
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        Vehicle obj = (Vehicle)context.getBean("car");
        obj.drive();
        context.close();

    }
}
