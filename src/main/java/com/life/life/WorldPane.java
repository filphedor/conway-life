package com.life.life;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class WorldPane extends JPanel implements Runnable {
    private BufferedImage image;
    private World world;
    private boolean isRunning;

    public WorldPane(World world) {
        this.world = world;
    }

    @Override
    public void run() {
        this.isRunning = true;

        while(this.isRunning) {
            this.image = WorldImager.toImage(this.world.getOrgs());

            this.repaint();

            try {
                Thread.sleep(16);
            } catch (Exception e) {

            }
        }
    }

    public void stop() {
        this.isRunning = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(this.image, 0, 0, null);
    }
}
