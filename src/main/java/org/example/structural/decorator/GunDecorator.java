package org.example.structural.decorator;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
public class GunDecorator implements Gun {
    private final Gun parentGun;


    @Override
    public int getDamage() {
        return parentGun.getDamage();
    }

    @Override
    public int getRange() {
        return parentGun.getRange();
    }

    @Override
    public int getAccuracy() {
        return parentGun.getAccuracy();
    }

    @Override
    public int getHandling() {
        return parentGun.getHandling();
    }
}
