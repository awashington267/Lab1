package spring.services;

import org.springframework.beans.factory.annotation.Value;

public class Characters implements IChar {


    @Override
    public int getID() {
        return 1;
    }

    @Override
    public String getName() {
        return "Musclebob Buffpants";
    }
}
