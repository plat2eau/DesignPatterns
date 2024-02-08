package org.example.structural.composite;

public class ComponentTest {

    public static void test() {
        Component hd = new Leaf(4000, "HDD");
        Component mouse = new Leaf(300, "Mouse");
        Component monitor = new Leaf(14000, "Monitor");
        Component ram = new Leaf(6000, "RAM");
        Component cpu = new Leaf(10000, "CPU");

        Composite ph = new Composite("Peri");
        Composite cb = new Composite("Cabinet");
        Composite mb = new Composite("Motherboard");
        Composite computer = new Composite("Computer");

        mb.addComponent(ram);
        mb.addComponent(cpu);
        ph.addComponent(mouse);
        ph.addComponent(monitor);
        cb.addComponent(hd);
        cb.addComponent(mb);
        computer.addComponent(ph);
        computer.addComponent(cb);
        computer.showPrice();
    }
}
