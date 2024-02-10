package org.example.structural;

import org.example.structural.adapter.TemperatureAdapter;
import org.example.structural.adapter.newSystem.NewTemperature;
import org.example.structural.adapter.oldSystem.CelsiusTemperature;
import org.example.structural.adapter.oldSystem.Temperature;
import org.example.structural.composite.ComponentTest;
import org.example.structural.decorator.*;
import org.example.structural.facade.Browser;
import org.example.structural.facade.ReportType;
import org.example.structural.facade.TestReportsHelperFacade;
import org.example.structural.proxy.AccessDeniedException;
import org.example.structural.proxy.DatabaseExecutorProxy;
import org.example.structural.proxy.User;

public class StructuralDesigns {

    public void adapter() {
        // Adapts old design object to fit in new design objects
        // Old style object expected in Temperature interface type
        Temperature celsiusTemperature = new CelsiusTemperature(22);
        // Adapter converts to new Style object expected in NewTemperature interface type
        NewTemperature temperatureAdapter = new TemperatureAdapter((CelsiusTemperature) celsiusTemperature);
        System.out.println(temperatureAdapter.getKelvinTemperature());
    }

    public void composite() {
        ComponentTest.test();
    }

    public void proxy() {
        DatabaseExecutorProxy adminExec = new DatabaseExecutorProxy(User.ADMIN);
        DatabaseExecutorProxy dataEntryExec = new DatabaseExecutorProxy(User.DATA_ENTRY);
        try {
            adminExec.executeQuery("custom delete query");
            dataEntryExec.executeQuery("custom delete query");
        } catch (AccessDeniedException e) {
            throw new RuntimeException(e);
        }
    }

    public void facade() {
        TestReportsHelperFacade testReportsHelper = new TestReportsHelperFacade();
        testReportsHelper.generateReports(Browser.CHROME, ReportType.JUNIT);
    }

    public void decorator() {
        Gun gun1 = new GunDecorator(new CompensatorDecorator(new GripDecorator(new BaseGun())));
        System.out.println("Gun 1:- Accuracy: " + gun1.getAccuracy());
        System.out.println("Gun 1:- Handling: " + gun1.getHandling());
        System.out.println("Gun 1:- Damage: " + gun1.getDamage());
        System.out.println("Gun 1:- Range: " + gun1.getRange());
        Gun gun2 = new GunDecorator(new LaserDecorator(new ScopeDecorator(new BaseGun())));
        System.out.println("Gun 2:- Accuracy: " + gun2.getAccuracy());
        System.out.println("Gun 2:- Handling: " + gun2.getHandling());
        System.out.println("Gun 2:- Damage: " + gun2.getDamage());
        System.out.println("Gun 2:- Range: " + gun2.getRange());

    }
}
