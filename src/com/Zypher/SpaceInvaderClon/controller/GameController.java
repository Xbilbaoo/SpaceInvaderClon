package com.Zypher.SpaceInvaderClon.controller;

import com.Zypher.SpaceInvaderClon.model.Alien;
import com.Zypher.SpaceInvaderClon.model.Bullet;
import com.Zypher.SpaceInvaderClon.model.PlayerSpace;
import com.Zypher.SpaceInvaderClon.view.GamePanel;

import java.util.ArrayList;

/**
 *
 * This class "controls" the game loop.
 *
 * @author Zypher
 * @version 0.1
 */
public class GameController implements Runnable {

    private final PlayerSpace player;
    private final ArrayList<Bullet> bullets;
    private final ArrayList<Alien> aliens;
    private final GamePanel view;
    private boolean isRunning = false;

    private static final int FIRE_RATE = 200;
    private long lastShotTime = 0;

    /**
     *
     * Constructor with needed attributes. In this process, it starts the game.
     *
     * @param player  Player instance.
     * @param view    View instance.
     * @param bullets An empty array to the bullets.
     * @param aliens  An empty array of enemies.
     */
    public GameController(PlayerSpace player, GamePanel view, ArrayList<Bullet> bullets, ArrayList<Alien> aliens) {

        this.player = player;
        this.view = view;
        this.bullets = bullets;
        this.aliens = aliens;

        createAliens();

        KeyHandler input = new KeyHandler(player, this);

        this.view.addKeyListener(input);
        this.view.setFocusable(true);
        this.view.requestFocusInWindow();

    }

    /**
     * Method to initiate the program
     */

    public void start() {

        isRunning = true;
        Thread gameThread = new Thread(this);
        gameThread.start();

    }

    /**
     * Method of the game loop.
     */

    @Override
    public void run() {

        while (isRunning) {

            long startTime = System.currentTimeMillis();

            update();

            view.repaint();

            long timeTaken = System.currentTimeMillis() - startTime;
            int FPS = 60;
            int TARGET_TIME = 1000 / FPS;
            long waitTime = TARGET_TIME - timeTaken;

            try {

                if (waitTime > 0) {
                    Thread.sleep(waitTime);
                }

            } catch (InterruptedException e) {
                System.err.println("error durante el bucle de juego: " + e);
            }
        }
    }

    /**
     * Method to sync the visual with the logic.
     */

    private void update() {

        player.tick(view.getWidth());


        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);
            b.tick(view.getWidth());

            if (b.getyPos() < 0) {
                bullets.remove(i);
                i--;
            }
        }

        for (Alien a : aliens) {
            a.tick(view.getWidth());
        }

        boolean hitEdge = false;

        for (Alien a : aliens) {

            if (a.getDx() > 0 && a.getxPos() >= view.getWidth() - a.getWidth()) {
                hitEdge = true;
                break;
            }

            if (a.getDx() < 0 && a.getxPos() <= 0) {
                hitEdge = true;
                break;
            }
        }

        if (hitEdge) {
            for (Alien a : aliens) {
                a.changeDirection();
                a.goDown();
            }
        }

        checkCollisions();
    }

    /**
     * This method allows to "shoot" bullets. Each bullet has a delay.
     */
    public void shoot() {

        long currentTime = System.currentTimeMillis();

        if (currentTime - lastShotTime > FIRE_RATE) {

            int bulletW = 6;
            int bulletH = 15;
            int xStart = player.getxPos() + (player.getWidth() / 2) - (bulletW / 2);
            int yStart = player.getyPos();

            Bullet newBullet = new Bullet(xStart, yStart, bulletW, bulletH);
            bullets.add(newBullet);


            lastShotTime = currentTime;
        }
    }

    /**
     * Method to create the enemies. At this moment there isn't
     * different difficulties, so there is a predefined pattern.
     */

    public void createAliens() {

        int startX = 20;
        int startY = 20;

        int paddingX = 40;
        int paddingY = 60;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 8; j++) {

                int xPos = startX + (j * (40 + paddingX));
                int yPos = startY + (i * (40 + paddingY));

                aliens.add(new Alien(xPos, yPos, 40, 40));

            }
        }
    }

    /**
     * Method to check collisions between a bullet and an enemy.
     */
    private void checkCollisions() {

        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);

            java.awt.Rectangle bulletRect = new java.awt.Rectangle(b.getxPos(), b.getyPos(), b.getWidth(), b.getHeight());

            for (int j = 0; j < aliens.size(); j++) {
                Alien a = aliens.get(j);

                java.awt.Rectangle alienRect = new java.awt.Rectangle(a.getxPos(), a.getyPos(), a.getWidth(), a.getHeight());

                if (bulletRect.intersects(alienRect)) {

                    aliens.remove(j);
                    bullets.remove(i);

                    i--;
                    break;
                }
            }
        }
    }

}
