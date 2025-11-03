package service;

import enums.Direction;
import models.Snake;

import java.util.Random;

public class SnakeCondition {


    private Snake snake;

    public SnakeCondition(Snake snake) {
        this.snake = snake;
    }


    public void update(int width,int height){
        snake.move();
        isEaten(width,height);
        isDead(isBorder(width,height));
    }


    public void handleInput(Direction direction){
        snake.setDirection(direction);
    }

    public boolean isBorder(int width,int height){
        if ((snake.getX() >= (width - snake.getSnakeWidth())) || (snake.getX() <= 0)
                || (snake.getY() >= (height - snake.getSnakeHeight())) || (snake.getY() <= 0))
        {
        snake.setDirection(null);
        return true;
        }
        return false;

    }
    public void isDead(boolean isBorder){
        if (isBorder) {
            System.out.println("GAME OVER!");
            snake.setX(1);
            snake.setY(1);
        }
    }


    public void spawnApple(int width,int height){
        Random random = new Random();
        snake.setAppleX(random.nextInt(width - snake.getSnakeWidth()));
        snake.setAppleY(random.nextInt(height - snake.getSnakeHeight()));
    }

    public void isEaten(int width, int height) {
        boolean xOverLap = ((snake.getX() + snake.getSnakeWidth()) > snake.getAppleX())
                && ((snake.getX()) < snake.getAppleX() + snake.getSnakeWidth());
        boolean yOverLap = ((snake.getY() + snake.getSnakeHeight()) > snake.getAppleY())
                && ((snake.getY()) < snake.getAppleY() + snake.getSnakeHeight());

        if (xOverLap && yOverLap) {
            spawnApple(width, height);
        }
    }


    }
