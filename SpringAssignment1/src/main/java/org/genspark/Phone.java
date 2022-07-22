package org.genspark;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Phone
{
    private String mob;

    public Phone()
    {
        this.mob = "1234567890";
    }

    public Phone(String mob)
    {
        this.mob = mob;
    }

    public String getMob()
    {
        return mob;
    }

    public void setMob(String mob)
    {
        this.mob = mob;
    }

    @Override
    public String toString()
    {
        return "Phone{" +
                "mob='" + mob + '\'' +
                '}';
    }
}
