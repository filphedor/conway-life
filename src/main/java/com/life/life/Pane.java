package com.life.life;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pane extends JPanel {
    private BufferedImage image;

    public void updateImg(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(this.image, 0, 0, null);
    }
}
