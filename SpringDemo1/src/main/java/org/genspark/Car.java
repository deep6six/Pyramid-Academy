package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle
{
    @Autowired
    public Tire t;

    public Car(){}
    public Car(Tire t) {this.t = t;}

    public void init() { System.out.println("I am in init() method"); }
    public void destroy() { System.out.println("I am in destroy() method"); }

    public void drive()
    {
        System.out.println("I am driving a car. " + t);
    }

    public Tire getT() {return t;}
    public void setT(Tire t) {this.t = t;}
}
