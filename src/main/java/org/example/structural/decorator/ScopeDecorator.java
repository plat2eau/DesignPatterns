package org.example.structural.decorator;

public class ScopeDecorator extends GunDecorator {
    public ScopeDecorator(Gun parentGun) {
        super(parentGun);
    }

    public int getRange() {
        return super.getRange() + 25;
    }
}
