package org.example.structural.facade;

public class ChromeTestRunner implements TestRunner {

    public void doChromeSpecificThings() {}

    @Override
    public void generateTestsReport() {
        System.out.println("Chrome test report generated");
    }

    @Override
    public void generateJunitReport() {
        System.out.println("Chrome Junit reports generated");
    }
}
