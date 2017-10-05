package com.mercadolibre.dojos;

public class BomberMan {
    private Cell location;
    private boolean isDead;

    public BomberMan(Cell bornPlace) {
        location = bornPlace;
    }

    public BomberMan() {

    }

    public void stepsInto(Cell cell) {
        cell.reclaimedBy(this);
        this.location = cell;
    }

    public boolean isIn(Cell cell) {
        return cell.equals(this.location);
    }

    public boolean isDead() {
        return isDead;
    }

    public void kill() {
        isDead = true;
    }

    public Bomb leavesBomb() {
        return new Bomb();
    }

    public Trajectory throwsBomb(Cell destination) {
        return new Trajectory(location, destination);
    }
}
