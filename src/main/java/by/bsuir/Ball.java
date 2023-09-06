package by.bsuir;

public class Ball {
    private int weight;
    private Color color;

    public Ball(int weight) {
        this.weight = weight;
        this.color = Color.GREEN;
    }

    public Ball(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return this.weight;
    }

    public Color getColor() {
        return this.color;
    }
}
