package org.example;

import org.example.structural.adapter.TemperatureAdapter;
import org.example.structural.adapter.newSystem.NewTemperature;
import org.example.structural.adapter.oldSystem.CelsiusTemperature;
import org.example.structural.adapter.oldSystem.Temperature;
import org.example.creational.builder.Phone;
import org.example.creational.builder.PhoneBuilder;
import org.example.structural.composite.ComponentTest;
import org.example.creational.factory.Environment;
import org.example.creational.factory.EnvironmentFactory;
import org.example.creational.factory.Stages;
import org.example.creational.factory.exceptions.NoSuchStageException;

public class Main {
    public static void main(String[] args) {
        // FACTORY makes it easier to get objects based on certain conditions
        try {
            Environment environment = new EnvironmentFactory().getEnvironment(Stages.ALPHA);
            environment.printStage();
        } catch (NoSuchStageException e) {
            throw new RuntimeException(e);
        }

        // BUILDER makes it easier to create object instead of remembering all params or passing null values
        Phone phone = new PhoneBuilder()
                .setOs("Android")
                .setBattery(3000)
                .build();

        System.out.println(phone);

        // ADAPTER adapts old design object to fit in new design objects
        // Old style object expected in Temperature interface type
        Temperature celsiusTemperature = new CelsiusTemperature(22);
        // Adapter converts to new Style object expected in NewTemperature interface type
        NewTemperature temperatureAdapter = new TemperatureAdapter((CelsiusTemperature) celsiusTemperature);
        System.out.println(temperatureAdapter.getKelvinTemperature());

        // COMPOSITE
        ComponentTest.test();
    }
}