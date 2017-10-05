package com.mercadolibre.dojos;

public class Address {
    private final int row;
    private final int col;

    public Address(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Address nextRight() {
        return new Address(row, col + 1);
    }

    @Override
    public boolean equals(Object other) {
        return ((Address) other).col == this.col && ((Address) other).row == this.row;
    }
}
