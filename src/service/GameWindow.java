package service;

import enums.Direction;
import models.Snake;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel implements Runnable
{
    private final int width = 300;
    private final int height = 300;
    Snake snake;
    Thread gameThread;

    public GameWindow(Snake snake) {
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.snake = snake;

        snake.setDirection(Direction.RIGHT); //FIX, MOVE TO ANOTHER PLACE
    }


    public void startThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
            while(gameThread != null){
                update();
                repaint();
                try {
//                    Thread.sleep(35); //  30 FPS
                    Thread.sleep(17); // 60 FPS
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
    }


    public void update() {
       snake.move();
       snake.isBorder(width,height);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        g2.setColor(Color.CYAN);
        g2.drawRect(snake.getX() ,snake.getY(),snake.getSnakeWidth(), snake.getSnakeHeight());
        g2.dispose();
    }

}
