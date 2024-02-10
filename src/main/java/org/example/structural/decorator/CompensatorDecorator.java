package org.example.structural.decorator;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


public class CompensatorDecorator extends GunDecorator{

    public CompensatorDecorator(Gun parentGun) {
        super(parentGun);
    }

    public int getDamage() {
        return super.getDamage() + 15;
    }
}
