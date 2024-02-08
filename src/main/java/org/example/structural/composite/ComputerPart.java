package org.example.structural.composite;


import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

interface Component {
    void showPrice();
}

@RequiredArgsConstructor
class Leaf implements Component {

    private final int price;
    private final String name;

    @Override
    public void showPrice() {
        System.out.println(this.name + " : " + this.price);
    }
}

@RequiredArgsConstructor
class Composite implements Component {

    private final String name;
    private final List<Component> components = new ArrayList<>();

    @Override
    public void showPrice() {
        System.out.println(this.name);
        for (Component com: this.components) {
            com.showPrice();
        }
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }
}