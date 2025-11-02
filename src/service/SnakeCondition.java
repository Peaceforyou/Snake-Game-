package service;

import enums.Direction;
import models.Snake;

public class SnakeCondition {


    private Snake snake;

    public SnakeCondition(Snake snake) {
        this.snake = snake;
    }


    public void update(int width,int height){
        snake.move();
        isBorder(width,height);
    }

    public void handleInput(Direction direction){
        snake.setDirection(direction);
    }

    public void isBorder(int width,int height){
        if ((snake.getX() >= (width - snake.getSnakeWidth())) || (snake.getX() <= 0)) {
            snake.setDirection(null);
        }
        if ((snake.getY() >= (height - snake.getSnakeHeight())) || (snake.getY() <= 0)) {
            snake.setDirection(null);
        }
    }

}
