package org.example.structural;

import org.example.structural.adapter.TemperatureAdapter;
import org.example.structural.adapter.newSystem.NewTemperature;
import org.example.structural.adapter.oldSystem.CelsiusTemperature;
import org.example.structural.adapter.oldSystem.Temperature;
import org.example.structural.composite.ComponentTest;

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
}
