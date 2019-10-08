package spring.services;

public class Roles implements IChar {
    @Override
    public int getID() {
        return 1;
    }

    @Override
    public String getName() {
        return "Tank";
    }
}
