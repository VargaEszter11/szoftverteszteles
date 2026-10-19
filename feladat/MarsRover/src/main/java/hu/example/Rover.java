package hu.example;

public class Rover {

    private static final String DIRECTIONS = "NESW";

    private final Planet planet;
    private int x;
    private int y;
    private char direction;

    public Rover(Planet planet, int x, int y, char direction) {
        this.planet = planet;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String execute(String commands) {
        for (char command : commands.toCharArray()) {
            String before = state();
            String report = execute(command);
            System.out.println("[Rover] " + command + ": " + before + " -> " + state());
            if (!report.isEmpty()) {
                System.out.println("[Rover] " + report + " - a holdjáró megáll");
                return report;
            }
        }
        return "";
    }

    private String execute(char command) {
        if (command == 'f') {
            return move(1);
        } else if (command == 'b') {
            return move(-1);
        } else if (command == 'l') {
            turn(-1);
        } else if (command == 'r') {
            turn(1);
        }
        return "";
    }

    private String state() {
        return "(" + x + "," + y + "," + direction + ")";
    }

    private void turn(int quarterTurns) {
        int index = DIRECTIONS.indexOf(direction);
        direction = DIRECTIONS.charAt(Math.floorMod(index + quarterTurns, DIRECTIONS.length()));
    }

    /** Lép egyet; akadály esetén az utolsó pontra tér vissza, és jelenti az akadályt. */
    private String move(int step) {
        int lastX = x;
        int lastY = y;
        char lastDirection = direction;
        switch (direction) {
            case 'N' -> y += step;
            case 'E' -> x += step;
            case 'S' -> y -= step;
            case 'W' -> x -= step;
        }
        x = Math.floorMod(x, planet.getWidth());
        if (y < 0 || y >= planet.getHeight()) {
            crossPole();
        }
        if (planet.hasObstacle(x, y)) {
            String report = "Akadály: (" + x + "," + y + ")";
            x = lastX;
            y = lastY;
            direction = lastDirection;
            return report;
        }
        return "";
    }

    private void crossPole() {
        y = Math.clamp(y, 0, planet.getHeight() - 1);
        x = (x + planet.getWidth() / 2) % planet.getWidth();
        turn(2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getDirection() {
        return direction;
    }
}
