package org.example.structural.decorator;

import lombok.ToString;

@ToString
public class BaseGun implements Gun {

    @Override
    public int getDamage() {
        return 40;
    }

    @Override
    public int getRange() {
        return 50;
    }

    @Override
    public int getAccuracy() {
        return 35;
    }

    @Override
    public int getHandling() {
        return 50;
    }
}
