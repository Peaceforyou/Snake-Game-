package service;

import enums.Direction;
import models.Snake;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel implements Runnable
{
    private final int width = 300;
    private final int height = 300;
    private SnakeCondition snakeCondition;
    private Snake snake;
    private Thread gameThread;

    public GameWindow() {
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.snake = new Snake(1,1);
        this.snakeCondition = new SnakeCondition(snake);
        snakeCondition.handleInput(Direction.RIGHT);

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new KeyHandler(snakeCondition));
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
       snakeCondition.update(width,height);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        g2.setColor(Color.CYAN);
        g2.drawRect(snake.getX() ,snake.getY(),snake.getSnakeWidth(), snake.getSnakeHeight());
        g2.dispose();
    }

}
