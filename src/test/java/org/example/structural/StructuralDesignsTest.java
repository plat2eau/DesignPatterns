package org.example.structural;

import org.example.structural.adapter.TemperatureAdapter;
import org.example.structural.adapter.newSystem.NewTemperature;
import org.example.structural.adapter.oldSystem.CelsiusTemperature;
import org.example.structural.adapter.oldSystem.Temperature;
import org.example.structural.composite.ComponentTest;
import org.example.structural.decorator.*;
import org.example.structural.dynamicProxy.Human;
import org.example.structural.dynamicProxy.LoggingHandler;
import org.example.structural.dynamicProxy.Person;
import org.example.structural.facade.Browser;
import org.example.structural.facade.ReportType;
import org.example.structural.facade.TestReportsHelperFacade;
import org.example.structural.proxy.AccessDeniedException;
import org.example.structural.proxy.DatabaseExecutorProxy;
import org.example.structural.proxy.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

class StructuralDesignsTest {

    @Test
    public void adapter() {
        // Adapts old design object to fit in new design objects
        // Old style object expected in Temperature interface type
        Temperature celsiusTemperature = new CelsiusTemperature(22);
        // Adapter converts to new Style object expected in NewTemperature interface type
        NewTemperature temperatureAdapter = new TemperatureAdapter((CelsiusTemperature) celsiusTemperature);
        temperatureAdapter.getKelvinTemperature();
    }

    @Test
    public void composite() {
        ComponentTest.test();
    }

    @Test
    public void proxy() throws Exception {
        DatabaseExecutorProxy adminExec = new DatabaseExecutorProxy(User.ADMIN);
        DatabaseExecutorProxy dataEntryExec = new DatabaseExecutorProxy(User.DATA_ENTRY);
        adminExec.executeQuery("custom delete query");
        assertThrows(AccessDeniedException.class, () -> dataEntryExec.executeQuery("custom delete query"));
    }

    @Test
    public void facade() {
        TestReportsHelperFacade testReportsHelper = new TestReportsHelperFacade();
        testReportsHelper.generateReports(Browser.CHROME, ReportType.JUNIT);
    }

    @Test
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

    @SuppressWarnings("unchecked")
    public static <T> T withLogging(T target, Class<T> inter) {
        return (T) Proxy.newProxyInstance(
                inter.getClassLoader(),
                new Class<?>[] {inter},
                new LoggingHandler(target)
        );
    }

    @Test
    public void dynamicProxy() {
        Person person = new Person();
        Human logged = withLogging(person, Human.class);
        logged.talk();
        logged.talk();
        logged.walk();
        System.out.println(logged);
    }
}