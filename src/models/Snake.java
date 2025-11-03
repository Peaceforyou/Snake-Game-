package models;

import enums.Direction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Snake {
    private int x;
    private int y;
    private int appleX;
    private int appleWidth =15 ;
    private int appleY;
    private int appleHeight = 15;
    private final int snakeWidth = 20;
    private final int SnakeHeight = 20;
    private int speed = 2;


   private Direction direction;


   public Snake(int x, int y) {
        this.x = x;
        this.y = y;
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
