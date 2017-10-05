package com.mercadolibre.dojos;

public class Explotion {
    public CellElement damage(Cell cell) {
        return cell.damage(new Fragment());
    }

    public void damage(Cell[] cells) {
        for (final Cell cell : cells) {
            damage(cell);
        }
    }
}
