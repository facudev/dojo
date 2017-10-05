package com.mercadolibre.dojos;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CellTest {

    @Test
    public void createRangeOfCells_from00To04() {

        Cell from = new Cell(new Address(0, 0));
        final List<Cell> cells = from.to(new Cell(new Address(0, 2)));

        final List<Cell> expected = new ArrayList<Cell>();
        expected.add(new Cell(new Address(0, 0)));
        expected.add(new Cell(new Address(0, 1)));
        expected.add(new Cell(new Address(0, 2)));
        assertEquals(expected, cells);
    }

}
