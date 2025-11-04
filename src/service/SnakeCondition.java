package service;

import enums.Direction;
import exceptions.DeathException;
import models.Point;
import models.Snake;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class SnakeCondition {

    private final Snake snake;

    public SnakeCondition(Snake snake) {
        this.snake = snake;
    }


    public void update(int width,int height) throws DeathException {
        snake.move();
        isEaten(width,height);
        isDead(isBorder(width,height),checkSelfCollision());
    }


    public void handleInput(Direction direction){
        snake.setDirection(direction);
    }

    public boolean isBorder(int width,int height){
        if ((snake.getXHead() >= (width - snake.getSnakeWidth())) || (snake.getXHead() <= 0)
                || (snake.getYHead() >= (height - snake.getSnakeHeight())) || (snake.getYHead() <= 0))
        {
            snake.setDirection(null);
            return true;
        }
        return false;

    }
    public void isDead(boolean isBorder,boolean checkCollision) throws DeathException {
        if (isBorder || checkCollision) {
            // Death logic
            snake.death();
        }
    }


    public void spawnApple(int width,int height){
        Random random = new Random();
        snake.setAppleX(random.nextInt(width - snake.getSnakeWidth()));
        snake.setAppleY(random.nextInt(height - snake.getSnakeHeight()));
    }

    public void isEaten(int width, int height) {
        boolean xOverLap = ((snake.getXHead() + snake.getSnakeWidth()) > snake.getAppleX())
                && ((snake.getXHead()) < snake.getAppleX() + snake.getSnakeWidth());
        boolean yOverLap = ((snake.getYHead() + snake.getSnakeHeight()) > snake.getAppleY())
                && ((snake.getYHead()) < snake.getAppleY() + snake.getSnakeHeight());

        if (xOverLap && yOverLap) {
            spawnApple(width, height);
            snake.addLength();
        }
    }

    public boolean checkSelfCollision() {
        Point head = snake.getBody().getFirst();
        List<Point> body =  (LinkedList<Point>)snake.getBody();

        for (int i = 2;i<body.size();i++){
            if (head.x() == body.get(i).x() && head.y() == body.get(i).y()){
                return true;
            }
        }
        return false;
    }
}
