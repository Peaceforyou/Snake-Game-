package service;


import exceptions.DeathException;
import models.GameResources;
import models.Point;
import models.Snake;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GameWindow extends JPanel implements Runnable
{
    private final int width = 300;
    private final int height = 300;
    private SnakeCondition snakeCondition;
    private Snake snake;
    private Thread gameThread;
    private DeathWindow deathWindow = new DeathWindow();

    public GameWindow() {
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        createSnake();

    }

    public void  createSnake() {
        this.snake = new Snake(150,150);
        this.snakeCondition = new SnakeCondition(snake);
        snakeCondition.handleInput(null);
        snakeCondition.spawnApple(width,height);

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
                try {
                    update();
                    repaint();


                    // 60 FPS
                    Thread.sleep(17);

                    //  30 FPS
//                   Thread.sleep(35);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //DEATH
                catch (DeathException e) {
                    System.out.println(e.getMessage());
                    deathWindow.showAndWait();
                    createSnake();
                }

            }
    }


    public void update() throws DeathException {
       snakeCondition.update(width,height);

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        drawSnake(g2,Color.magenta);
        drawApple(g2,Color.RED);
        g2.dispose();
    }

    public void drawSnake(Graphics g2,Color color){
        LinkedList<Point> list = (LinkedList<Point>) snake.getBody();
        g2.setColor(color);
        for (int i = 0;i < list.size();i++) {
            g2.fillRect(list.get(i).x(),list.get(i).y(),snake.getSnakeWidth(),snake.getSnakeHeight());
        }
    }

    public void drawApple(Graphics g2,Color color){
        g2.setColor(color);
        ImageIcon apple = GameResources.getApple();
        apple.paintIcon(this, g2, snake.getAppleX(), snake.getAppleY());
    }

}

