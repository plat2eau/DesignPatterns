package org.example.creational.factory.environments;

import org.example.creational.factory.Environment;

public class Beta implements Environment {
    @Override
    public void printStage() {
        System.out.println("Beta");
    }
}
