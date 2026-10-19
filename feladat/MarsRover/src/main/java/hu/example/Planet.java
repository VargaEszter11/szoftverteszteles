package hu.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Planet {

    private final int width;
    private final int height;
    private final Set<List<Integer>> obstacles = new HashSet<>();

    public Planet(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addObstacle(int x, int y) {
        obstacles.add(List.of(x, y));
    }

    public boolean hasObstacle(int x, int y) {
        return obstacles.contains(List.of(x, y));
    }
}
