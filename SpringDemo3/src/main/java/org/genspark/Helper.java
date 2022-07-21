package org.genspark;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
//Advice->What | PointCut->Where
public class Helper
{
    @Before("execution(public void show())")
    public void logOpen() { System.out.println("Logging"); }

    @After("execution(public void show())")
    public void logClose() { System.out.println("Log Stop"); }
}
