package service;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enums.Direction;

public class KeyHandler implements KeyListener {


    private GameCondition gameCondition;

    public KeyHandler(GameCondition gameCondition) {
        this.gameCondition = gameCondition;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_D){
            gameCondition.handleInput(Direction.RIGHT);

        }
        if (code == KeyEvent.VK_W){
            gameCondition.handleInput(Direction.UP);

        }
        if (code == KeyEvent.VK_S){
            gameCondition.handleInput(Direction.DOWN);

        }
        if (code == KeyEvent.VK_A){
            gameCondition.handleInput(Direction.LEFT);

        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

