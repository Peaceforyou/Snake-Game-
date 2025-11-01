package service;

import models.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enums.Direction;

public class KeyHandler implements KeyListener {


    Snake snake;

    public KeyHandler(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_D){
            snake.setDirection(Direction.RIGHT);

        }
        if (code == KeyEvent.VK_W){
            snake.setDirection(Direction.UP);

        }
        if (code == KeyEvent.VK_S){
            snake.setDirection(Direction.DOWN);

        }
        if (code == KeyEvent.VK_A){
            snake.setDirection(Direction.LEFT);

        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

