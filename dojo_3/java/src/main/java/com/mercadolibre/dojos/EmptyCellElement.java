package com.mercadolibre.dojos;

public class EmptyCellElement implements CellElement {
    public void bumpsWith(BomberMan bomberMan) {
        // Nothing
    }

    public CellElement damage(Fragment fragment) {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }
}
