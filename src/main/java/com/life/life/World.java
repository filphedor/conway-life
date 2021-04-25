package com.life.life;

import java.util.Random;

public class World implements Runnable {
    private boolean[][] orgs;
    private int width;
    private int height;
    private boolean isRunning = true;

    public World(int width, int height) {
        this.orgs = new boolean[width][height];
        this.width = width;
        this.height = height;
    }

    public void seedWorld(int seed, int prob) {
        Random generator = new Random(seed);

        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                int rand = (int) (generator.nextDouble() * 100);

                if (rand < prob) {
                    this.orgs[i][j] = true;
                } else {
                    this.orgs[i][j] = false;
                }
            }
        }
    }

    public boolean[][] getOrgs() {
        return this.orgs;
    }

    public void stop() {
        this.isRunning = false;
    }

    @Override
    public void run() {
        this.isRunning = true;

        while (this.isRunning) {
            this.update();
        }
    }

    public void update() {
        long start = System.currentTimeMillis();

        boolean[][] newOrgs = new boolean[width][height];

        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                int numNeighbors = this.getNumNeighbors(i, j);

                if (this.orgs[i][j]) {
                    if (numNeighbors < 2) {
                        newOrgs[i][j] = false;
                    } else if (numNeighbors < 4) {
                        newOrgs[i][j] = true;
                    } else {
                        newOrgs[i][j] = false;
                    }
                }

                if (!this.orgs[i][j]) {
                    if (numNeighbors == 3) {
                        newOrgs[i][j] = true;
                    } else {
                        newOrgs[i][j] = false;
                    }
                }
            }
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);

        this.orgs = newOrgs;
    }

    private int getNumNeighbors(int x, int y) {
        int numNeighbors = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i > 0 && x + i < this.width && y + j > 0 && y + j < this.height && !(i == 0 && j == 0)) {
                    if (this.orgs[x + i][y + j]) {
                        numNeighbors += 1;
                    }
                }
            }
        }

        return numNeighbors;
    }
}
