package org.example.structural.adapter;

import lombok.AllArgsConstructor;
import org.example.structural.adapter.newSystem.NewTemperature;
import org.example.structural.adapter.oldSystem.CelsiusTemperature;

@AllArgsConstructor
public class TemperatureAdapter implements NewTemperature {
    private CelsiusTemperature celsiusTemperature;

    public double getKelvinTemperature() {
        return celsiusTemperature.getCelsiusTemperature() + 273.15;
    }

    public double getFahrenheitTemperature() {
        return (celsiusTemperature.getCelsiusTemperature()* 9 / 5) + 32;
    }

}
