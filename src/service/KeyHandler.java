package service;

import models.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enums.Direction;

public class KeyHandler implements KeyListener {


    private SnakeCondition snakeCondition;

    public KeyHandler(SnakeCondition snakeCondition) {
        this.snakeCondition = snakeCondition;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_D){
            snakeCondition.handleInput(Direction.RIGHT);

        }
        if (code == KeyEvent.VK_W){
            snakeCondition.handleInput(Direction.UP);

        }
        if (code == KeyEvent.VK_S){
            snakeCondition.handleInput(Direction.DOWN);

        }
        if (code == KeyEvent.VK_A){
            snakeCondition.handleInput(Direction.LEFT);

        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

