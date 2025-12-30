package service;


import exceptions.DeathException;
import interfaces.Drawable;
import models.Point;
import models.Snake;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameWindow extends JPanel implements Runnable
{
    private final int width = GameConstants.WINDOW_WIDTH;
    private final int height = GameConstants.WINDOW_HEIGHT;
    private GameCondition gameCondition;
    private Snake snake;
    private Thread gameThread;
    private DeathWindow deathWindow1;
    List<Drawable> drawableList = new ArrayList<>();

    public GameWindow() {
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(GameConstants.BACKGROUND_COLOR);
        this.setDoubleBuffered(true);
        createSnakeAndApple(new Snake(GameConstants.START_POINT_X,GameConstants.START_POINT_Y));

    }

    public void createSnakeAndApple(Snake snake) {
        this.snake = snake;
        this.gameCondition = new GameCondition(snake);
        gameCondition.handleInput(null);
        gameCondition.spawnApple();

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new KeyHandler(gameCondition));
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
                    Thread.sleep(GameConstants.FPS);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //DEATH
                catch (DeathException e) {
                    System.out.println(e.getMessage());
                    deathWindow1 = new DeathWindow(snake.getScore());
                    deathWindow1.showAndWait();
                    createSnakeAndApple(new Snake(GameConstants.START_POINT_X,GameConstants.START_POINT_Y));
                }

            }
    }


    public void update() throws DeathException {
        snake.move();
        gameCondition.update();

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        snake.draw(g,this);
        gameCondition.getApple().draw(g2,this);
        g2.dispose();
    }



}

