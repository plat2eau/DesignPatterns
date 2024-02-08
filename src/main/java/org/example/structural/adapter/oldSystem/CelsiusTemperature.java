package org.example.structural.adapter.oldSystem;

public class CelsiusTemperature implements Temperature {
    private final double temperatureCelsius;

    public CelsiusTemperature(double temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    public double getCelsiusTemperature() {
        return temperatureCelsius;
    }

    public double getFahrenheitTemperature() {
        return (temperatureCelsius * 9 / 5) + 32;
    }
}
