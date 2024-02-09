package org.example.creational.singleton;

public enum LoggerEnum {
    INSTANCE;
    public int i;

    public void show() {
        System.out.println(i);
    }
}
