package models;

import javax.swing.*;
import java.awt.*;

public class GameResources {
    private static final String applePhoto = "images/Apple.png";


    public static ImageIcon getApple() {

        return new ImageIcon(GameResources.class.getResource("/" + applePhoto));
    }}

