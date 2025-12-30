package models;

import interfaces.Drawable;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Apple implements Drawable {
    private int appleWidth = GameConstants.APPLE_WIDTH;
    private int appleHeight = GameConstants.APPLE_HEIGHT;

    private int appleX;
    private int appleY;


    public Apple(int appleX, int appleY) {
        this.appleX = appleX;
        this.appleY = appleY;
    }

    public void spawn(int windowWidth,int windowHeight,int snakeHeight,int snakeWidth) {
        Random random = new Random();
        setAppleX(random.nextInt(windowWidth - snakeWidth));
        setAppleY(random.nextInt(windowHeight - snakeHeight));
    }




    public int getAppleWidth() {
        return appleWidth;
    }

    public void setAppleWidth(int appleWidth) {
        this.appleWidth = appleWidth;
    }

    public int getAppleHeight() {
        return appleHeight;
    }

    public void setAppleHeight(int appleHeight) {
        this.appleHeight = appleHeight;
    }

    public int getAppleY() {
        return appleY;
    }

    public void setAppleY(int appleY) {
        this.appleY = appleY;
    }

    public int getAppleX() {
        return appleX;
    }

    public void setAppleX(int appleX) {
        this.appleX = appleX;
    }

    @Override
    public void draw(Graphics g, Component component) {
        ImageIcon appleImage = GameResources.getApple();

        appleImage.paintIcon(component, g,
                getAppleX(),getAppleY());
    }
}