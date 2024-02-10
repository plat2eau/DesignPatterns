package org.example.structural.facade;

public class TestReportsHelperFacade {

    public void generateReports(Browser browser, ReportType reportType) {
        TestRunner testRunner = null;
        switch (browser) {
            case CHROME: testRunner = new ChromeTestRunner();
            break;
            case FIREFOX: testRunner = new FirefoxTestRunner();
            break;
        }
        switch (reportType) {
            case TEST:
                testRunner.generateTestsReport();
                break;
            case JUNIT:
                testRunner.generateJunitReport();
        }
    }
}
