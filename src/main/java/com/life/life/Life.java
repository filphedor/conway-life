package com.life.life;

import javax.swing.*;

public class Life {
    public static void main(String[] args) {
        World world = new World( 2000, 2000);
        world.seedWorld(2348572, 50);

        JFrame frame = buildFrame();
        WorldPane pane = new WorldPane(world);
        frame.add(pane);

        Thread worldThread = new Thread(world);
        worldThread.start();

        Thread paneThread = new Thread(pane);
        paneThread.start();

        try {
            Thread.sleep(30000);
        } catch (Exception e) {

        }

        world.stop();
        pane.stop();
    }

    private static JFrame buildFrame() {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(2000, 2000);
        frame.setVisible(true);

        return frame;
    }
}
