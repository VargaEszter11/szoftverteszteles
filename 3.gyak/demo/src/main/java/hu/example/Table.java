package hu.example;



public class Table {
    private static final int MIN_HEIGHT = 0;
    private static final int MAX_HEIGHT = 200;
    private static final int CM_PER_PERSON = 60;

    private int width, length, height, currentHeight;
    private boolean isAdjustable;
    private String color;
    private int numberOfLegs;

    public Table(int width, int length, int height, String color, int numberOfLegs) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.currentHeight = height;
        this.isAdjustable = false;
        this.color = color;
        this.numberOfLegs = numberOfLegs;
    }

    public Table(int width, int length, int height, int currentHeight, String color, int numberOfLegs) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.currentHeight = currentHeight;
        this.isAdjustable = true;
        this.color = color;
        this.numberOfLegs = numberOfLegs;
    }

    private static boolean isValidHeight(int h) {
        return h >= MIN_HEIGHT && h <= MAX_HEIGHT;
    }

    public void setHeight(int newHeight) {
        if (!isAdjustable) {
            throw new IllegalStateException("Az asztal magassága nem állítható.");
        }
        if (!isValidHeight(newHeight)) {
            throw new IllegalArgumentException("Az új magasságnak a [0, 200] intervallumban kell lennie.");
        }
        this.currentHeight = newHeight;
    }

    public int area() {
        return width * length;
    }

    public int getCapacity() {
        return getPerimeter() / CM_PER_PERSON;
    }

    public void repaint(String newColor) {
        this.color = newColor;
    }

    public boolean isStable() {
        return numberOfLegs >= 3;
    }

    public boolean isFoldable() {
        return isAdjustable && numberOfLegs >= 4;
    }

    public int getPerimeter() {
        return 2 * (width + length);
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public boolean isAdjustable() {
        return isAdjustable;
    }

    public int getCurrentHeight() {
        return currentHeight;
    }
}