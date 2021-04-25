package com.life.life;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Life {
    public static void main(String[] args) {
        World world = new World(1000, 1000);
        world.setUp(50);

        BufferedImage image = WorldImager.toImage(world.getOrgs());

        JFrame frame = buildFrame();

        Pane pane = new Pane();
        pane.updateImg(image);

        frame.add(pane);

        while(true) {
            world.update();

            image = WorldImager.toImage(world.getOrgs());
            pane.updateImg(image);
            pane.repaint();

            try {
                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private static JFrame buildFrame() {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);

        return frame;
    }
}
