package org.example.structural.decorator;

public class LaserDecorator extends GunDecorator{
    public LaserDecorator(Gun parentGun) {
        super(parentGun);
    }

    public int getAccuracy() {
        return super.getAccuracy() + 10;
    }
}
