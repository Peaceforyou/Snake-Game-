package models;

import enums.Direction;
import exceptions.DeathException;
import lombok.Getter;
import lombok.Setter;

import java.util.Deque;
import java.util.LinkedList;


@Getter
@Setter
public class Snake {
    private int length;
    private int xHead;
    private int yHead;
    private int appleX;
    private int appleWidth =15 ;
    private int appleY;
    private int appleHeight = 15;
    private final int snakeWidth = 20;
    private final int SnakeHeight = 20;
    private int speed = 3;
    private final Point startPosition = new Point(1,1);
    private Deque<Point> body = new LinkedList<>();

   private Direction direction;


   public Snake(int x, int y) {
       this.xHead = x;
       this.yHead = y;
       body.addFirst(startPosition);

    }

    public void move(){
        if (direction == Direction.RIGHT) {
            xHead += speed;
        }
        if (direction == Direction.UP) {
            yHead  -= speed;

        }
        if (direction == Direction.DOWN) {
            yHead  += speed;
        }if (direction == Direction.LEFT) {
            xHead  -= speed;
        }
        body.removeLast();
        body.addFirst(new Point(xHead,yHead));
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
    public void addLength() {
       body.addFirst(new Point(xHead,yHead));

    }
    public void death() throws DeathException {
       throw new DeathException("GAME OVER");
    }

    }



