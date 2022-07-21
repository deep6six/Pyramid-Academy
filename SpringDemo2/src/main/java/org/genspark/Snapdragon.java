package org.genspark;

import org.springframework.stereotype.Component;

@Component
public class Snapdragon implements MobileProcessor
{
    @Override
    public void processor() { System.out.println("Snapdragon: World's Best Processor"); }
}
