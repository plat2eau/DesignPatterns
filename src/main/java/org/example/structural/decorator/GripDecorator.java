package org.example.structural.decorator;

public class GripDecorator extends GunDecorator{
    public GripDecorator(Gun parentGun) {
        super(parentGun);
    }

    public int getHandling() {
        return super.getHandling() + 20;
    }
}
