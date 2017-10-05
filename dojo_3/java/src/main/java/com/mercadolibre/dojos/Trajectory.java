package com.mercadolibre.dojos;

public class Trajectory {
    private final Cell destination;
    private final Cell location;

    public Trajectory(Cell location, Cell destination) {
        this.location = location;
        this.destination = destination;
    }

    public Explotion swish() {
        return new Explotion();
    }
}
