package service;

import enums.Direction;
import exceptions.DeathException;
import models.Apple;
import models.Point;
import models.Snake;

import java.util.LinkedList;
import java.util.List;

public class GameCondition {

    private final Snake snake;
    private final Apple apple;

    public Apple getApple() {
        return apple;
    }

    public GameCondition(Snake snake) {
        this.snake = snake;
        this.apple = new Apple(0,0);
    }


    public void update() throws DeathException {
//        snake.move();
        isEaten();
        isDead(isBorder(),checkSelfCollision());
    }


    public void handleInput(Direction direction){
        snake.setDirection(direction);
    }

    public boolean isBorder(){
        if ((snake.getXHead() >= (GameConstants.WINDOW_WIDTH - GameConstants.SNAKE_WIDTH)) || (snake.getXHead() <= 0)
                || (snake.getYHead() >= (GameConstants.WINDOW_HEIGHT - GameConstants.SNAKE_HEIGHT)) || (snake.getYHead() <= 0))
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


    public void spawnApple(){
        apple.spawn(GameConstants.WINDOW_WIDTH,GameConstants.WINDOW_HEIGHT,
                GameConstants.SNAKE_HEIGHT, GameConstants.SNAKE_WIDTH);


    }

    public void isEaten() {
        boolean xOverLap = ((snake.getXHead() + GameConstants.SNAKE_WIDTH) > apple.getAppleX())
                && ((snake.getXHead()) < apple.getAppleX() + GameConstants.SNAKE_WIDTH);
        boolean yOverLap = ((snake.getYHead() + GameConstants.SNAKE_HEIGHT) > apple.getAppleY())
                && ((snake.getYHead()) < apple.getAppleY() + GameConstants.SNAKE_HEIGHT);

        if (xOverLap && yOverLap) {
            spawnApple();
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
