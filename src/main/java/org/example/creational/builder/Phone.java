package org.example.creational.builder;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Phone {

    private String os;

    private String processor;

    private double screenSize;

    private int battery;

    private int camera;
}
