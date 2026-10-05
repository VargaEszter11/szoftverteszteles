package hu.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TableTest {

    // setHeight

    @Test
    public void setHeightChangesCurrentHeightOfAdjustableTable() {
        Table table = new Table(80, 120, 75, 75, "barna", 4);

        table.setHeight(110);

        assertEquals(110, table.getCurrentHeight());
    }

    @Test
    public void setHeightAcceptsLowerBoundary() {
        Table table = new Table(80, 120, 75, 75, "barna", 4);

        table.setHeight(0);

        assertEquals(0, table.getCurrentHeight());
    }

    @Test
    public void setHeightAcceptsUpperBoundary() {
        Table table = new Table(80, 120, 75, 75, "barna", 4);

        table.setHeight(200);

        assertEquals(200, table.getCurrentHeight());
    }

    @Test(expected = IllegalStateException.class)
    public void setHeightThrowsOnNonAdjustableTable() {
        Table table = new Table(80, 120, 75, "barna", 4);

        table.setHeight(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setHeightThrowsBelowRange() {
        Table table = new Table(80, 120, 75, 75, "barna", 4);

        table.setHeight(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setHeightThrowsAboveRange() {
        Table table = new Table(80, 120, 75, 75, "barna", 4);

        table.setHeight(201);
    }

    // area

    @Test
    public void areaIsWidthTimesLength() {
        Table table = new Table(80, 120, 75, "barna", 4);

        assertEquals(9600, table.area());
    }

    @Test
    public void areaOfSmallestTableIsOne() {
        Table table = new Table(1, 1, 75, "barna", 4);

        assertEquals(1, table.area());
    }

    // getCapacity

    @Test
    public void capacityIsPerimeterDividedBySixty() {
        Table table = new Table(80, 120, 75, "barna", 4); // kerület: 400 cm

        assertEquals(6, table.getCapacity());
    }

    @Test
    public void capacityExactlyOnePersonAtSixtyCm() {
        Table table = new Table(15, 15, 75, "barna", 4); // kerület: 60 cm

        assertEquals(1, table.getCapacity());
    }

    @Test
    public void capacityIsZeroBelowSixtyCm() {
        Table table = new Table(10, 10, 75, "barna", 4); // kerület: 40 cm

        assertEquals(0, table.getCapacity());
    }

    @Test
    public void capacityRoundsDown() {
        Table table = new Table(50, 50, 75, "barna", 4); // kerület: 200 cm -> 3.33

        assertEquals(3, table.getCapacity());
    }

    // repaint

    @Test
    public void repaintChangesColor() {
        Table table = new Table(80, 120, 75, "barna", 4);

        table.repaint("piros");

        assertEquals("piros", table.getColor());
    }

    // isStable

    @Test
    public void tableWithThreeLegsIsStable() {
        Table table = new Table(80, 120, 75, "barna", 3);

        assertTrue(table.isStable());
    }

    @Test
    public void tableWithFourLegsIsStable() {
        Table table = new Table(80, 120, 75, "barna", 4);

        assertTrue(table.isStable());
    }

    @Test
    public void tableWithTwoLegsIsNotStable() {
        Table table = new Table(80, 120, 75, "barna", 2);

        assertFalse(table.isStable());
    }

    // isFoldable

    @Test
    public void adjustableTableWithFourLegsIsFoldable() {
        Table table = new Table(80, 120, 75, 75, "barna", 4);

        assertTrue(table.isFoldable());
    }

    @Test
    public void adjustableTableWithMoreThanFourLegsIsFoldable() {
        Table table = new Table(80, 120, 75, 75, "barna", 6);

        assertTrue(table.isFoldable());
    }

    @Test
    public void adjustableTableWithThreeLegsIsNotFoldable() {
        Table table = new Table(80, 120, 75, 75, "barna", 3);

        assertFalse(table.isFoldable());
    }

    @Test
    public void nonAdjustableTableWithFourLegsIsNotFoldable() {
        Table table = new Table(80, 120, 75, "barna", 4);

        assertFalse(table.isFoldable());
    }

    // getPerimeter

    @Test
    public void perimeterIsTwiceWidthPlusLength() {
        Table table = new Table(80, 120, 75, "barna", 4);

        assertEquals(400, table.getPerimeter());
    }

    @Test
    public void perimeterOfSquareTable() {
        Table table = new Table(50, 50, 75, "barna", 4);

        assertEquals(200, table.getPerimeter());
    }
}
