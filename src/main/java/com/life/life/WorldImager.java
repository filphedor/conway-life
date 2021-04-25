package com.life.life;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WorldImager {
    public static BufferedImage toImage(boolean[][] orgs) {
        int width = orgs.length;
        int height = orgs[0].length;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Color alive = new Color(0, 200, 30);
        Color dead = new Color(200, 50, 30);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (orgs[i][j]) {
                    image.setRGB(i, j, alive.getRGB());
                } else {
                    image.setRGB(i, j, dead.getRGB());
                }
            }
        }

        return image;
    }
}
