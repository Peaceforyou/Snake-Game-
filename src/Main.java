import models.Snake;
import service.GameWindow;
import service.KeyHandler;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Snake snake = new Snake(1,1);

        //Frame settings
        JFrame frame = new JFrame();
        frame.addKeyListener(new KeyHandler(snake));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Snake!");


       GameWindow gameWindow = new GameWindow(snake);
       frame.add(gameWindow);

       //Starting game
       gameWindow.startThread();

       //Frame settings
       frame.pack();
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);



    }




}