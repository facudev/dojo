package com.mercadolibre.dojos;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Tests for the dojo.
 */
public class DojoTest {

	@Test
	public void testBomberMan_stepsInto_aEmptyCell() {
		final BomberMan bomberMan = new BomberMan();
		final Cell cell = new Cell();

		bomberMan.stepsInto(cell);

		assertTrue(bomberMan.isIn(cell));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testBomberMan_stepsInto_aNonEmptyCell() {
	    final Cell bornPlace = new Cell();
		final BomberMan bomberMan = new BomberMan(bornPlace);

		final Cell cell = new Cell(new Wall());

		bomberMan.stepsInto(cell);

		assertTrue(bomberMan.isIn(bornPlace));
	}

	@Test
    public void testBomberMan_stepsInto_aCellWithAnEnemy_andDie() {
        final Cell bornPlace = new Cell();
        final BomberMan bomberMan = new BomberMan(bornPlace);

        final Cell cell = new Cell(new Bolban());

        bomberMan.stepsInto(cell);

        assertTrue(bomberMan.isDead());
    }

	@Test
	public void testBomberMan_dropABomb_itExplodes_andBreakTheWall() {
		final Cell bornPlace = new Cell();
		final BomberMan bomberMan = new BomberMan(bornPlace);

		final Cell cell = new Cell(new Wall());

		Bomb bomb = bomberMan.leavesBomb();
		final Explotion explotion = bomb.tick();
		explotion.damage(cell);

		assertTrue(cell.isEmpty());
	}

	@Test
	public void testBomberMan_dropABomb_itExplodes_andKillBolban() {
		final Cell bornPlace = new Cell();
		final BomberMan bomberMan = new BomberMan(bornPlace);

		final Cell cell = new Cell(new Bolban());
		final Cell emptyCell = new Cell(new EmptyCellElement());


		Bomb bomb = bomberMan.leavesBomb();
		final Explotion explotion = bomb.tick();

		final Cell cells[] = {cell, emptyCell};
		explotion.damage(cells);

		assertTrue(emptyCell.isEmpty());
		assertTrue(cell.isEmpty());
	}

	@Test
	public void testBomberMan_throwsABomb_itExplodes_andBreakTheWall() {
		final Cell bornPlace = new Cell();
		final BomberMan bomberMan = new BomberMan(bornPlace);

		final Cell cell = new Cell(new Wall());

		Trajectory trajectory = bomberMan.throwsBomb(cell);

		trajectory.swish();
		Explotion explotion = trajectory.swish();
		explotion.damage(cell);

		assertTrue(cell.isEmpty());
	}

    @Test
    public void testBomberMan_leavesABomb_itExplodes_andBreaksInARangeOfOne() {
        final Cell bornPlace = new Cell();
        final BomberMan bomberMan = new BomberMan(bornPlace);

        final Cell firstWall = new Cell(new Wall());
        final Cell secondWall = new Cell(new Wall());
        final Cell cells[] = {
                firstWall,
                new Cell(),
                new Cell(),
                new Cell(),
                bornPlace,
                secondWall,
                new Cell(),
                new Cell(),
                new Cell()
        };

        Bomb bomb = bomberMan.leavesBomb();
        Explotion explotion = bomb.tick();
        explotion.damage(cells);

        assertTrue(bornPlace.isEmpty());
        assertTrue(firstWall.isEmpty());
        assertTrue(secondWall.isEmpty());
    }

}