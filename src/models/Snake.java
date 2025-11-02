package models;

import enums.Direction;

public class Snake {
    private int x;
    private int y;
    private final int snakeWidth = 20;
    private final int snakeHeight = 20;
    private int speed = 2;


   private Direction direction;


   public Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSnakeWidth() {
        return snakeWidth;
    }

    public int getSnakeHeight() {
        return snakeHeight;
    }

    public void move(){
        if (direction == Direction.RIGHT) {
            x += speed;
        }
        if (direction == Direction.UP) {
            y  -= speed;

        }
        if (direction == Direction.DOWN) {
            y  += speed;
        }if (direction == Direction.LEFT) {
            x  -= speed;
        }
    }

    public Direction getDirection() {
        return direction;

    }

    public void setDirection(Direction direction) {

        if (this.direction == null) {
            this.direction = direction;
        }

        if ((this.direction == Direction.RIGHT & direction != Direction.LEFT) ||
                (this.direction == Direction.LEFT & direction != Direction.RIGHT))
        {
            this.direction = direction;

        } else if ((this.direction == Direction.UP & direction != Direction.DOWN) ||
                (this.direction == Direction.DOWN & direction != Direction.UP))
        {

            this.direction = direction;
        }


    }


}
