package org.example.structural;

import org.example.structural.adapter.TemperatureAdapter;
import org.example.structural.adapter.newSystem.NewTemperature;
import org.example.structural.adapter.oldSystem.CelsiusTemperature;
import org.example.structural.adapter.oldSystem.Temperature;
import org.example.structural.composite.ComponentTest;
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
}
