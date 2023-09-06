package by.bsuir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basket {
    private List<Ball> storage = null;

    public Basket() {
        storage = new ArrayList<>();
    }

    public Basket(Ball[] balls) {
        storage = new ArrayList<>();
        storage.addAll(Arrays.asList(balls));
    }

    public void addBall(Ball ball) {
        storage.add(ball);
    }

    public void addAllBalls(Ball[] balls) {
        storage.addAll(Arrays.asList(balls));
    }

    public int countBallsWeight() {
        int weight = 0;
        if (storage != null) {
            for (Ball ball: storage) {
                weight += ball.getWeight();
            }
        }
        return weight;
    }

    public int countBlueBalls() {
        int counter = 0;
        if (storage != null) {
            for (Ball ball: storage) {
                if (ball.getColor() == Color.BLUE) {
                    counter++;
                }
            }
        }
        return counter;
    }

}
