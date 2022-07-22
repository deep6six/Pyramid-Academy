package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle
{
    @Autowired
    public Tire t;

    public void drive()
    {
        System.out.println("I am riding a bike");
    }

    public Tire getT() { return t; }

    public void setT(Tire t) { this.t = t; }
}
