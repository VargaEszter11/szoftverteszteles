package hu.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class RoverTest {

    @BeforeEach
    void logTestName(TestInfo info) {
        System.out.println("\n=== " + info.getDisplayName());
    }

    @Test
    void roverKeepsInitialPositionAndDirection() {
        Rover rover = new Rover(new Planet(10, 10), 3, 4, 'N');

        assertEquals(3, rover.getX());
        assertEquals(4, rover.getY());
        assertEquals('N', rover.getDirection());
    }

    @Test
    void forwardFacingNorthIncreasesY() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'N');

        rover.execute("f");

        assertEquals(5, rover.getX());
        assertEquals(6, rover.getY());
    }

    @Test
    void forwardFacingEastIncreasesX() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'E');

        rover.execute("f");

        assertEquals(6, rover.getX());
        assertEquals(5, rover.getY());
    }

    @Test
    void forwardFacingSouthDecreasesY() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'S');

        rover.execute("f");

        assertEquals(5, rover.getX());
        assertEquals(4, rover.getY());
    }

    @Test
    void forwardFacingWestDecreasesX() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'W');

        rover.execute("f");

        assertEquals(4, rover.getX());
        assertEquals(5, rover.getY());
    }

    @Test
    void backwardFacingNorthDecreasesY() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'N');

        rover.execute("b");

        assertEquals(5, rover.getX());
        assertEquals(4, rover.getY());
    }

    @Test
    void leftFacingNorthTurnsWest() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'N');

        rover.execute("l");

        assertEquals('W', rover.getDirection());
        assertEquals(5, rover.getX());
        assertEquals(5, rover.getY());
    }

    @Test
    void leftFacingWestTurnsSouth() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'W');

        rover.execute("l");

        assertEquals('S', rover.getDirection());
    }

    @Test
    void rightFacingNorthTurnsEast() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'N');

        rover.execute("r");

        assertEquals('E', rover.getDirection());
        assertEquals(5, rover.getX());
        assertEquals(5, rover.getY());
    }

    @Test
    void roverExecutesAllCommandsInOrder() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'N');

        rover.execute("ffrff");

        assertEquals(7, rover.getX());
        assertEquals(7, rover.getY());
        assertEquals('E', rover.getDirection());
    }

    @Test
    void movingEastFromLastColumnWrapsToFirstColumn() {
        Rover rover = new Rover(new Planet(10, 10), 9, 5, 'E');

        rover.execute("f");

        assertEquals(0, rover.getX());
        assertEquals(5, rover.getY());
        assertEquals('E', rover.getDirection());
    }

    @Test
    void movingWestFromFirstColumnWrapsToLastColumn() {
        Rover rover = new Rover(new Planet(10, 10), 0, 5, 'W');

        rover.execute("f");

        assertEquals(9, rover.getX());
        assertEquals(5, rover.getY());
        assertEquals('W', rover.getDirection());
    }

    @Test
    void movingNorthOverNorthPoleLeadsToOppositeColumnFacingSouth() {
        Rover rover = new Rover(new Planet(10, 10), 2, 9, 'N');

        rover.execute("f");

        assertEquals(7, rover.getX());
        assertEquals(9, rover.getY());
        assertEquals('S', rover.getDirection());
    }

    @Test
    void movingSouthOverSouthPoleLeadsToOppositeColumnFacingNorth() {
        Rover rover = new Rover(new Planet(10, 10), 2, 0, 'S');

        rover.execute("f");

        assertEquals(7, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals('N', rover.getDirection());
    }

    @Test
    void roverStaysOnLastPointWhenObstacleIsAhead() {
        Planet planet = new Planet(10, 10);
        planet.addObstacle(5, 6);
        Rover rover = new Rover(planet, 5, 5, 'N');

        rover.execute("f");

        assertEquals(5, rover.getX());
        assertEquals(5, rover.getY());
    }

    @Test
    void roverReportsTheObstacle() {
        Planet planet = new Planet(10, 10);
        planet.addObstacle(5, 6);
        Rover rover = new Rover(planet, 5, 5, 'N');

        String report = rover.execute("f");

        assertEquals("Akadály: (5,6)", report);
    }

    @Test
    void roverStopsExecutingCommandsAtTheObstacle() {
        Planet planet = new Planet(10, 10);
        planet.addObstacle(5, 7);
        Rover rover = new Rover(planet, 5, 5, 'N');

        String report = rover.execute("fffrf");

        assertEquals("Akadály: (5,7)", report);
        assertEquals(5, rover.getX());
        assertEquals(6, rover.getY());
        assertEquals('N', rover.getDirection());
    }

    @Test
    void roverStaysOnLastPointWhenObstacleIsBehind() {
        Planet planet = new Planet(10, 10);
        planet.addObstacle(5, 4);
        Rover rover = new Rover(planet, 5, 5, 'N');

        String report = rover.execute("b");

        assertEquals("Akadály: (5,4)", report);
        assertEquals(5, rover.getX());
        assertEquals(5, rover.getY());
    }

    // ------------------------------------------------------------------
    // Utólag hozzáadott megerősítő tesztek.
    // Ezek nem TDD-ciklusban születtek: a kód már általános szabályokat
    // használ, ezért megírásuk pillanatában is zöldek voltak (nem volt RED).
    // Azt védik, hogy a már működő viselkedés ne romoljon el.
    // ------------------------------------------------------------------

    @Test
    void backwardFacingEastDecreasesX() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'E');

        rover.execute("b");

        assertEquals(4, rover.getX());
        assertEquals(5, rover.getY());
    }

    @Test
    void backwardFacingSouthIncreasesY() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'S');

        rover.execute("b");

        assertEquals(5, rover.getX());
        assertEquals(6, rover.getY());
    }

    @Test
    void backwardFacingWestIncreasesX() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'W');

        rover.execute("b");

        assertEquals(6, rover.getX());
        assertEquals(5, rover.getY());
    }

    @Test
    void backwardFacingEastFromFirstColumnWrapsToLastColumn() {
        Rover rover = new Rover(new Planet(10, 10), 0, 5, 'E');

        rover.execute("b");

        assertEquals(9, rover.getX());
        assertEquals(5, rover.getY());
        assertEquals('E', rover.getDirection());
    }

    @Test
    void leftFacingSouthTurnsEast() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'S');

        rover.execute("l");

        assertEquals('E', rover.getDirection());
    }

    @Test
    void leftFacingEastTurnsNorth() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'E');

        rover.execute("l");

        assertEquals('N', rover.getDirection());
    }

    @Test
    void rightFacingEastTurnsSouth() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'E');

        rover.execute("r");

        assertEquals('S', rover.getDirection());
    }

    @Test
    void rightFacingSouthTurnsWest() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'S');

        rover.execute("r");

        assertEquals('W', rover.getDirection());
    }

    @Test
    void rightFacingWestTurnsNorth() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'W');

        rover.execute("r");

        assertEquals('N', rover.getDirection());
    }

    @Test
    void fourLeftTurnsLeaveRoverFacingTheSameWay() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'N');

        rover.execute("llll");

        assertEquals('N', rover.getDirection());
        assertEquals(5, rover.getX());
        assertEquals(5, rover.getY());
    }

    @Test
    void movingBackwardOverNorthPoleLeadsToOppositeColumnFacingNorth() {
        Rover rover = new Rover(new Planet(10, 10), 2, 9, 'S');

        rover.execute("b");

        assertEquals(7, rover.getX());
        assertEquals(9, rover.getY());
        assertEquals('N', rover.getDirection());
    }

    @Test
    void movingBackwardOverSouthPoleLeadsToOppositeColumnFacingSouth() {
        Rover rover = new Rover(new Planet(10, 10), 2, 0, 'N');

        rover.execute("b");

        assertEquals(7, rover.getX());
        assertEquals(0, rover.getY());
        assertEquals('S', rover.getDirection());
    }

    @Test
    void obstacleBehindTheNorthPoleKeepsPositionAndDirection() {
        Planet planet = new Planet(10, 10);
        planet.addObstacle(7, 9);
        Rover rover = new Rover(planet, 2, 9, 'N');

        String report = rover.execute("f");

        assertEquals("Akadály: (7,9)", report);
        assertEquals(2, rover.getX());
        assertEquals(9, rover.getY());
        assertEquals('N', rover.getDirection());
    }

    @Test
    void obstacleBehindTheEastEdgeKeepsPosition() {
        Planet planet = new Planet(10, 10);
        planet.addObstacle(0, 5);
        Rover rover = new Rover(planet, 9, 5, 'E');

        String report = rover.execute("f");

        assertEquals("Akadály: (0,5)", report);
        assertEquals(9, rover.getX());
        assertEquals(5, rover.getY());
    }

    @Test
    void reportIsEmptyWhenThereIsNoObstacle() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'N');

        assertEquals("", rover.execute("ffrff"));
    }

    @Test
    void unknownCommandsAreIgnored() {
        Rover rover = new Rover(new Planet(10, 10), 5, 5, 'N');

        rover.execute("fxf");

        assertEquals(5, rover.getX());
        assertEquals(7, rover.getY());
        assertEquals('N', rover.getDirection());
    }
}
