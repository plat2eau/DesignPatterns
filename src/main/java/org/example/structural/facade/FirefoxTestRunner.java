package org.example.structural.facade;

public class FirefoxTestRunner implements TestRunner {

    public void doFirefoxSpecificThings() {}

    @Override
    public void generateTestsReport() {
        System.out.println("Firefox test report generated");
    }

    @Override
    public void generateJunitReport() {
        System.out.println("Firefox Junit reports generated");
    }
}
