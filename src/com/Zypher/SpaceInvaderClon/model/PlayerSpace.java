package com.Zypher.SpaceInvaderClon.model;

public class PlayerSpace extends Entity {

    private int dx;

    /**
     *
     * @param xPos
     * @param yPos
     * @param width
     * @param height
     */
    public PlayerSpace(int xPos, int yPos, int width, int height) {
        super(xPos, yPos, width, height);
        this.dx = 0;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    @Override
    public void tick() {

    }
}
