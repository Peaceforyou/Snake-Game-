package models;

import enums.Direction;
import interfaces.Drawable;


import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;



public class Snake implements Drawable {
    private int xHead;
    private int yHead;
    private final int snakeWidth = GameConstants.SNAKE_WIDTH;
    private final int SnakeHeight = GameConstants.SNAKE_HEIGHT;
    private int speed = GameConstants.SPEED;
    private final Point startPosition = new Point(1,1);
    private Deque<Point> body = new LinkedList<>();
    private int score = 0;
   private Direction direction;


   public Snake(int x, int y) {
       this.xHead = x;
       this.yHead = y;
       body.addFirst(startPosition);

    }

    public void move(){
       if (direction != null){
           xHead += direction.x * speed;
           yHead += direction.y * speed;
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
        score++;
    }

    public int getXHead() {
        return xHead;
    }


    public int getYHead() {
        return yHead;
    }



    public Deque<Point> getBody() {
        return body;
    }


    public int getScore() {
        return score;
    }

    @Override
    public void draw(Graphics g, Component component) {
        LinkedList<Point> list = (LinkedList<Point>) getBody();
        g.setColor(GameConstants.SNAKE_COLOR);
        for (Point point : body) {
            g.fillRect(point.x(), point.y(), snakeWidth, SnakeHeight);
        }
    }
}



