package org.genspark;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context1 = new ClassPathXmlApplicationContext("Spring.xml");
        Student obj = (Student)context1.getBean("student");
        System.out.println(obj);


        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = (Student)context.getBean(Student.class);
        System.out.println(student);
    }
}
