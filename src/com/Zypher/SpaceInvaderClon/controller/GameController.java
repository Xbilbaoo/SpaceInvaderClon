package com.Zypher.SpaceInvaderClon.controller;

import com.Zypher.SpaceInvaderClon.model.Bullet;
import com.Zypher.SpaceInvaderClon.model.PlayerSpace;
import com.Zypher.SpaceInvaderClon.view.GamePanel;

import java.util.ArrayList;

public class GameController implements Runnable {

    private PlayerSpace player;
    private ArrayList<Bullet> bullets;
    private GamePanel view;
    private boolean isRunning = false;

    private final int FPS = 60;
    private final int TARGET_TIME = 1000 / FPS;

    private static final int FIRE_RATE = 400;
    private long lastShotTime = 0;

    public GameController(PlayerSpace player, GamePanel view, ArrayList<Bullet> bullets) {

        this.player = player;
        this.view = view;
        this.bullets = bullets;
        KeyHandler input = new KeyHandler(player, this);

        this.view.addKeyListener(input);
        this.view.setFocusable(true);
        this.view.requestFocusInWindow();

    }

    public void start() {

        isRunning = true;
        Thread gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        while (isRunning) {

            long startTime = System.currentTimeMillis();

            update();

            view.repaint();

            long timeTaken = System.currentTimeMillis() - startTime;
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

    private void update() {
        // 1. Mover Jugador
        player.tick(view.getWidth());

        // 2. Mover Balas
        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);
            b.tick(view.getWidth()); // Mueve la bala hacia arriba

            // 3. Limpieza: Si la bala sale de la pantalla (Y < 0), la borramos
            // para no llenar la memoria del ordenador infinitamente.
            if (b.getyPos() < 0) {
                bullets.remove(i);
                i--; // Importante: al borrar, retrocedemos el índice para no saltarnos la siguiente
            }
        }
    }

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

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

}
