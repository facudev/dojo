package com.mercadolibre.dojos;

public interface CellElement {
    void bumpsWith(BomberMan bomberMan);

    CellElement damage(Fragment fragment);

    boolean equals(Object obj);
}
