package com.mercadolibre.dojos;

public class Bolban implements CellElement {
    public void bumpsWith(BomberMan bomberMan) {
        bomberMan.kill();
    }

    public CellElement damage(Fragment fragment) {
        return new EmptyCellElement();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass());
    }
}
