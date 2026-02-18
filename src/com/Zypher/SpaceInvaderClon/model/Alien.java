package com.Zypher.SpaceInvaderClon.model;

public class Alien extends Entity {

    private int dx;

    /**
     *
     * Constructor with all attributes.
     *
     * @param xPos   Initial X position of the entity
     * @param yPos   Initial Y position of the entity
     * @param width  Initial width of the entity
     * @param height Initial height of the entity
     */
    public Alien(int xPos, int yPos, int width, int height) {

        super(xPos, yPos, width, height);
        this.dx = 1;

    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    @Override
    public void tick(int screenWidth) {
        setxPos(getxPos() + dx);
    }

    public void changeDirection() {
        setDx(getDx() * -1);
    }

    public void goDown() {
        setyPos(getyPos() + 20);
    }
}
