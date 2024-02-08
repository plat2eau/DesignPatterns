package org.example.creational.factory.environments;

import org.example.creational.factory.Environment;

public class Alpha implements Environment {
    @Override
    public void printStage() {
        System.out.println("Alpha");
    }
}
