package com.Zypher.SpaceInvaderClon.model;

public class PlayerSpace extends Entity {

    private int dx;

    /**
     *
     * @param xPos   Initial X position of the player
     * @param yPos   Initial Y position of the player
     * @param width  Initial width of the player
     * @param height Initial height of the player
     */
    public PlayerSpace(int xPos, int yPos, int width, int height) {
        super(xPos, yPos, width, height);
        this.dx = 0;
    }

    /**
     * Getter of attribute dx
     *
     * @return The actual "speed" of the X axis
     */
    public int getDx() {
        return dx;
    }

    /**
     * Method to change the "speed" of the player
     *
     * @param dx The new "speed".
     */
    public void setDx(int dx) {
        this.dx = dx;
    }

    @Override
    public void tick(int screenWidth) {

        this.setxPos(this.getxPos() + this.getDx());

        if (this.getxPos() < 0) {
            setxPos(0);
        } else if (this.getxPos() > (screenWidth - this.getWidth())) {

            setxPos((screenWidth - this.getWidth()));
        }


    }
}
