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

    public GameController(PlayerSpace player, GamePanel view, ArrayList<Bullet> bullets) {

        this.player = player;
        this.view = view;
        this.bullets = new ArrayList<>();
        KeyHandler input = new KeyHandler(player, bullets);

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
        // MATEMÁTICA: Centrar la bala en la nave
        // X = Posición Nave + Mitad Nave - Mitad Bala
        int bulletW = 6;
        int bulletH = 15;
        int xStart = player.getxPos() + (player.getWidth() / 2) - (bulletW / 2);
        int yStart = player.getyPos(); // Sale de la punta de arriba

        Bullet newBullet = new Bullet(xStart, yStart, bulletW, bulletH);
        bullets.add(newBullet);
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

}
