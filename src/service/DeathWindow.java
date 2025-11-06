package service;

import javax.swing.*;
import java.awt.*;


class DeathWindow extends JFrame {
    private final Object lock = new Object();

    public DeathWindow() {
        super("Game Over");
        setSize(200, 100);
        setLocationRelativeTo(null);

        JButton b = new JButton("OK");
        b.addActionListener(e -> {
            synchronized(lock) { lock.notify(); }
            dispose();
        });

        add(new JLabel("Game Over!", SwingConstants.CENTER));
        add(b, "South");
    }

    public void showAndWait() {
        setVisible(true);
        synchronized(lock) {
            try { lock.wait(); } catch (InterruptedException e) {}
        }
    }
}