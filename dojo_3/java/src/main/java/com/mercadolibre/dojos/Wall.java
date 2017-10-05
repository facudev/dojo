package com.mercadolibre.dojos;

public class Wall implements CellElement {
    public void bumpsWith(BomberMan bomberMan) {
        throw new IllegalStateException("Hay una pared");
    }

    public CellElement damage(Fragment fragment) {
        return new EmptyCellElement();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }
}
