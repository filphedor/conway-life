package com.life.life;

public class World {
    private boolean[][] orgs;
    private boolean[][] check;
    private int width;
    private int height;

    public World(int width, int height) {
        this.orgs = new boolean[width][height];
        this.check = new boolean[width][height];
        this.width = width;
        this.height = height;
    }

    public void setUp(int prob) {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.check[i][j] = true;
                int rand = (int) (Math.random() * 100);

                if (rand > prob) {
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

    public void update() {
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
