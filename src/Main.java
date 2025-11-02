
import service.GameWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //Frame settings
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Snake!");


       GameWindow gameWindow = new GameWindow();
       frame.add(gameWindow);

       //Starting game
       gameWindow.startThread();

       //Frame settings
       frame.pack();
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);



    }

}