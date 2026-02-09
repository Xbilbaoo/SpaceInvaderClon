package com.Zypher.SpaceInvaderClon.model;

import java.awt.Rectangle;

public abstract class Entity {

    private int xPos;
    private int yPos;
    private int width;
    private int height;

    /**
     *
     * Constructor with all attributes.
     * @param xPos Initial X position of the entity
     * @param yPos Initial Y position of the entity
     * @param width Initial width of the entity
     * @param height Initial heigth of the entity
     */

    public Entity(int xPos, int yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    /**
     * Getter for the xPos attribute
     * @return The x position of an entity
     */
    public int getxPos() { return xPos; }

    /**
     * Getter for the yPos attribute
     * @return The y position of an entity
     */
    public int getyPos() { return yPos; }

    /**
     * Getter for the width attribute
     * @return The exact width of an entity
     */
    public int getWidth() { return width; }

    /**
     * Getter for the height attribute
     * @return The exact height of an entity
     */
    public int getHeight() { return height; }

    /**
     * Method to change the X position of an entity
     * @param xPos The new position of an entity on X axis
     */
    public void setxPos(int xPos) { this.xPos = xPos; }

    /**
     * Method to change the Y position of an entity
     * @param yPos The new position of an entity on Y axis
     */
    public void setyPos(int yPos) { this.yPos = yPos; }


    // Next two setters are to change the "hitbox" of an entity

    /**
     *
     * @param width The new width of an entity
     */
    public void setWidth(int width) { this.width = width; }

    /**
     *
     * @param height The new height of an entity
     */
    public void setHeight(int height) { this.height = height; }

    /**
     * Method the get the collision box of an entity.
     * Used to check collisions between entities.
     * @return A Rectangle object representing the area occupied by the entity.
     */
    public Rectangle getBounds() { return new Rectangle(xPos, yPos, width,height); }

    /**
     * Updates the logic of an entity
     */
    public abstract void tick();
}
