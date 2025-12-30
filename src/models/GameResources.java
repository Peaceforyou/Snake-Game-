package models;

import javax.swing.*;
import java.awt.*;

public class GameResources {
    private static final String applePhoto = "images/Apple.png";
    private static final ImageIcon apple;
    static {
        apple = new ImageIcon(GameResources.class.getResource(("/" + applePhoto)));
    }

    public static ImageIcon getApple() {

        return apple;

    }}

