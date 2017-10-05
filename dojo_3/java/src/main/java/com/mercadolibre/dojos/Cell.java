package com.mercadolibre.dojos;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private Address address;
    private CellElement cellElement;

    public Cell(CellElement cellElement) {
        this.cellElement = cellElement;
    }

    public Cell() {
        cellElement = new EmptyCellElement();
    }

    public Cell(Address address) {
        this.address = address;
        cellElement = new EmptyCellElement();
    }

    /**
     * @param bomberMan
     */
    public void reclaimedBy(BomberMan bomberMan) {
        cellElement.bumpsWith(bomberMan);
    }

    public CellElement damage(Fragment fragment) {
        return cellElement = cellElement.damage(fragment);
    }

    public boolean isEmpty() {
        return cellElement.equals(new EmptyCellElement());
    }

    public Cell nextRight() {
        return new Cell(address.nextRight());
    }

    public List<Cell> to(Cell dest) {
        final List<Cell> result = new ArrayList<Cell>();
        result.add(this);
        result.add(this.nextRight());
        result.add(dest);

        return result;
    }


    @Override
    public boolean equals(Object object) {
        return ((Cell) object).isAddressedBy(this);
    }

    private boolean isAddressedBy(Cell cell) {
        return this.address.equals(cell.address);
    }

}