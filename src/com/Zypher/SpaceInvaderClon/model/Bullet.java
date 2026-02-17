package com.Zypher.SpaceInvaderClon.model;

public class Bullet extends Entity {

    private int dy;

    /**
     *
     * Basic constructor for bullet
     * @param xPos
     * @param yPos
     * @param width
     * @param height
     */
    public Bullet(int xPos, int yPos, int width, int height) {
        super(xPos, yPos, width, height);
        this.dy = 5;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void tick(int screenWidth) {

        this.setyPos(this.getyPos() - this.getDy());

    }
}
